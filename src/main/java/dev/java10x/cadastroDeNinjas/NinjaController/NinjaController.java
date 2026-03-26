package dev.java10x.cadastroDeNinjas.NinjaController;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/home")
    public String home(){

        return "<h1>Spring application Ninjas Running</h1>";
    }
}
