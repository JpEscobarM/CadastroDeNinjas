package dev.java10x.cadastroDeNinjas.Missao.Service;

import dev.java10x.cadastroDeNinjas.Missao.Repository.MissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MissaoService {

    @Autowired
    MissaoRepository missaoRepository;

}
