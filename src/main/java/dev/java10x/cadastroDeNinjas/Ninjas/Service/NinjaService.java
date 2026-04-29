package dev.java10x.cadastroDeNinjas.Ninjas.Service;

import dev.java10x.cadastroDeNinjas.Missao.Repository.MissaoRepository;
import dev.java10x.cadastroDeNinjas.Ninjas.Model.Ninja;
import dev.java10x.cadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import dev.java10x.cadastroDeNinjas.Ninjas.dto.NinjaDTO;
import dev.java10x.cadastroDeNinjas.Ninjas.mapper.NinjaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    @Autowired
    NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<Ninja> findAllNinjas()
    {
        return ninjaRepository.findAll();
    }

    public Ninja findById(Long id){

        Optional<Ninja> ninjaOptional = ninjaRepository.findById(id);

        Ninja ninjaEncontrado = ninjaOptional.orElseThrow(()->new RuntimeException("Ninja nao encontrado"));

        return ninjaEncontrado;
    }


    public Ninja criarNinja(Ninja ninja){


        return  ninjaRepository.save(ninja);
    }


    public void deleteNinja(Long id) {
        ninjaRepository.deleteById(id);
    }

    public Ninja atualizarNinja(Long id,Ninja ninjaAtualizado){

        if(ninjaRepository.existsById(id))
        {
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }

    return null;
    }


}
