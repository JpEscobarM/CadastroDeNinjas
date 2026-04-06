package dev.java10x.cadastroDeNinjas.Ninjas.Service;

import dev.java10x.cadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NinjaService {

    @Autowired
    NinjaRepository ninjaRepository;

}
