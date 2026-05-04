package dev.java10x.cadastroDeNinjas.Ninjas.Controller;

import dev.java10x.cadastroDeNinjas.Ninjas.Model.Ninja;
import dev.java10x.cadastroDeNinjas.Ninjas.Service.NinjaService;
import dev.java10x.cadastroDeNinjas.Ninjas.dto.NinjaDTO;
import dev.java10x.cadastroDeNinjas.Ninjas.mapper.NinjaMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ninja")
public class NinjaController {

    @Autowired
    NinjaService ninjaService;

    // CREATE
    @PostMapping
    public ResponseEntity<?> criarNinja(@RequestBody NinjaDTO novoNinja) {

        Ninja ninjaCriado = ninjaService.criarNinja(NinjaMapper.toEntity(novoNinja));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(NinjaMapper.toDTO(ninjaCriado));
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarNinjaPorId(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(NinjaMapper.toDTO(ninjaService.findById(id)));
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<?> buscarTodos() {


        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        ninjaService.findAllNinjas()
                        .stream()
                        .map(NinjaMapper::toDTO)
                        .toList()
                );

    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAlterado) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body( NinjaMapper.toDTO(ninjaService.atualizarNinja(id,ninjaAlterado)));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarNinja(@PathVariable Long id) {

        ninjaService.deleteNinja(id);

     return ResponseEntity.noContent().build();
    }

}