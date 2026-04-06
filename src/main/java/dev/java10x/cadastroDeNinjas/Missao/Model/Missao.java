package dev.java10x.cadastroDeNinjas.Missao.Model;

import dev.java10x.cadastroDeNinjas.Ninjas.Enums.Ranking;
import dev.java10x.cadastroDeNinjas.Ninjas.Model.Ninja;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "missao")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Missao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dificuldade")
    private Ranking dificuldade;

    @OneToMany(mappedBy = "missao")
    private List<Ninja> listaNinjas;

}
