package dev.java10x.cadastroDeNinjas.Ninjas.Controller;

import dev.java10x.cadastroDeNinjas.Ninjas.Model.Ninja;
import dev.java10x.cadastroDeNinjas.Ninjas.Service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ninja")
public class NinjaController {

    @Autowired
    NinjaService ninjaService;

    // CREATE
    @PostMapping
    public ResponseEntity<?> criarNinja(@RequestBody Ninja novoNinja) {

        Ninja ninjaCriado = ninjaService.ninjaCreate(novoNinja);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ninjaCriado);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarNinjaPorId(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ninjaService.findById(id));
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ninjaService.findAllNinjas());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> alterarNinja(@PathVariable Long id, @RequestBody Ninja ninjaAlterado) {



        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Ninja alterado com id: " + id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarNinja(@PathVariable Long id) {

        ninjaService.deleteNinja(id);

     return ResponseEntity.noContent().build();
    }
}