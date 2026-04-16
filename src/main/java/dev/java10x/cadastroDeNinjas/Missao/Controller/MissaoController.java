package dev.java10x.cadastroDeNinjas.Missao.Controller;

import dev.java10x.cadastroDeNinjas.Missao.Model.Missao;
import dev.java10x.cadastroDeNinjas.Missao.Service.MissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/missao")
public class MissaoController {

    @Autowired
    MissaoService missaoService;


    //CREATE
    @PostMapping("/criar")
    public ResponseEntity<?> criarMissao(@RequestBody Missao aNonCreatedMission)
    {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(aNonCreatedMission);
    }


    //READ
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarMissaoPorId(@PathVariable Long id)
    {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Response");
    }

    @GetMapping("/all")
    public ResponseEntity<?> buscarTodos()
    {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Response");
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id,@RequestBody Missao anAlteredMission)
    {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Response");
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarMissao(@PathVariable Long id, @RequestBody Missao aMissionForDelete)
    {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Response");
    }


}
