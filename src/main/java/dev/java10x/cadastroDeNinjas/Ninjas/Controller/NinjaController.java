package dev.java10x.cadastroDeNinjas.Ninjas.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/home/api/ninja")
    public String home(){

        return "<h1>Spring application Ninjas Controller Running</h1>";
    }
}
