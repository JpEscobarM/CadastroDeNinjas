package dev.java10x.cadastroDeNinjas.Ninjas.Controller;

import dev.java10x.cadastroDeNinjas.Ninjas.Model.Ninja;
import dev.java10x.cadastroDeNinjas.Ninjas.Service.NinjaService;
import dev.java10x.cadastroDeNinjas.Ninjas.dto.NinjaDTO;
import dev.java10x.cadastroDeNinjas.Ninjas.mapper.NinjaMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/api/ninja/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    // READ ALL
    @GetMapping
    public String buscarTodos(Model model) {
        List<NinjaDTO> ninjas = ninjaService.findAllNinjas()
                .stream()
                .map(NinjaMapper::toDTO)
                .toList();

        model.addAttribute("ninjas", ninjas);

        return "ninjas"; //tem que retornar o nome da pagina que renderiza
    }

    @PostMapping ("/deletar/{id}")
    public String deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deleteNinja(id);
        return "redirect:/api/ninja/ui";
    }

    @GetMapping("/{id}")
    public String buscarNinjaPorId(@PathVariable Long id, Model model) {

       Ninja ninja= ninjaService.findById(id);

       model.addAttribute("ninja",ninja);

        return "detalhesninja";
    }


    // CREATE
    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionar(Model model) {

        model.addAttribute("ninjaNovo",new NinjaDTO());

        return "adicionarNinja";
    }


    // CREATE
    @PostMapping
    public String criarNinja(@ModelAttribute NinjaDTO novoNinja, RedirectAttributes redirectAttributes) {

        Ninja ninjaCriado = ninjaService.criarNinja(NinjaMapper.toEntity(novoNinja));

        redirectAttributes.addFlashAttribute("mensagem", "Ninja cadastrado com sucesso!");

        return "redirect:/api/ninja/ui";
    }


}
