package dev.java10x.cadastroDeNinjas.Ninjas.Service;

import dev.java10x.cadastroDeNinjas.Missao.Repository.MissaoRepository;
import dev.java10x.cadastroDeNinjas.Ninjas.Model.Ninja;
import dev.java10x.cadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    @Autowired
    NinjaRepository ninjaRepository;
    @Autowired
    MissaoRepository missaoRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<Ninja> findAllNinjas()
    {
        return ninjaRepository.findAll();
    }

    public Ninja findById(Long id){

        Optional<Ninja> ninjaOptional = ninjaRepository.findById(id);

        Ninja ninja = ninjaOptional.orElseThrow(()->new RuntimeException("Ninja nao encontrado"));

        return ninja;
    }


    public Ninja ninjaCreate(Ninja ninja){




        return  ninjaRepository.save(ninja);
    }


}
