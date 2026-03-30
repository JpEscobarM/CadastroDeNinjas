package dev.java10x.cadastroDeNinjas.Missao.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MissaoController {

    @GetMapping("/home/api/missao")
    public String home(){

        return "<h1>Spring application Missao Controller Running</h1>";
    }
}
