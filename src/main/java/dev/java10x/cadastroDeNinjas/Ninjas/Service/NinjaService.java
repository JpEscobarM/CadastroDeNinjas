package dev.java10x.cadastroDeNinjas.Ninjas.Service;

import dev.java10x.cadastroDeNinjas.Missao.Repository.MissaoRepository;
import dev.java10x.cadastroDeNinjas.Ninjas.Model.Ninja;
import dev.java10x.cadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import dev.java10x.cadastroDeNinjas.Ninjas.dto.NinjaDTO;
import dev.java10x.cadastroDeNinjas.Ninjas.exception.NinjaNotFoundException;
import dev.java10x.cadastroDeNinjas.Ninjas.mapper.NinjaMapper;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {


    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {

        this.ninjaRepository = ninjaRepository;
    }

    public List<Ninja> findAllNinjas()
    {
        return ninjaRepository.findAll();
    }

    public Ninja findById(Long id){

        Optional<Ninja> ninjaOptional = ninjaRepository.findById(id);

        Ninja ninjaEncontrado = ninjaOptional.orElseThrow(() -> new NinjaNotFoundException(id));


        return ninjaEncontrado;
    }


    public Ninja criarNinja(Ninja ninja){


        return  ninjaRepository.save(ninja);
    }


    public void deleteNinja(Long id) {

        Ninja ninja = ninjaRepository.findById(id).orElseThrow(() -> new NinjaNotFoundException(id));


        ninjaRepository.deleteById(id);
    }

    public Ninja atualizarNinja(Long id,NinjaDTO ninjaAtualizado){

        Optional<Ninja> ninjaExistente = ninjaRepository.findById(id);

        Ninja ninja = ninjaExistente.orElseThrow(() -> new NinjaNotFoundException(id));

        return  ninjaRepository.save(NinjaMapper.toEntity(ninjaAtualizado));

    }


}
