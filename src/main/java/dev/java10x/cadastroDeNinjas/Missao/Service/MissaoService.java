package dev.java10x.cadastroDeNinjas.Missao.Service;

import dev.java10x.cadastroDeNinjas.Missao.Model.Missao;
import dev.java10x.cadastroDeNinjas.Missao.Repository.MissaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {


    MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    public List<Missao> findAllMissoes(){
        return missaoRepository.findAll();
    }

    public Missao findById(Long id)
    {

        Optional<Missao> missaoOptional= missaoRepository.findById(id);


        Missao missao = missaoOptional.orElseThrow(() -> new RuntimeException("Missao nao encontrada"));
        return missao;
    }


}
