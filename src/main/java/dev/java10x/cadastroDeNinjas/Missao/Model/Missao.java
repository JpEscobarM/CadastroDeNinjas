package dev.java10x.cadastroDeNinjas.Missao.Model;

import dev.java10x.cadastroDeNinjas.Ninjas.Enums.Ranking;
import dev.java10x.cadastroDeNinjas.Ninjas.Model.Ninja;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "missao")
public class Missao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;


    private Ranking dificuldade;

    private List<Ninja> listaNinjas;

}
