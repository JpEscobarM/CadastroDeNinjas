package dev.java10x.cadastroDeNinjas.Ninjas.Controller;


import dev.java10x.cadastroDeNinjas.Ninjas.Service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {

    @Autowired
    NinjaService ninjaService;

    @GetMapping("/home/api/ninja")
    public String home(){

        return "<h1>Spring application Ninjas Controller Running</h1>";
    }
}
