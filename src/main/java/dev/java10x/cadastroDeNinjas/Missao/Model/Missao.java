package dev.java10x.cadastroDeNinjas.Missao.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.cadastroDeNinjas.Missao.Enums.Ranking;
import dev.java10x.cadastroDeNinjas.Ninjas.Model.Ninja;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "missao")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Missao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dificuldade")
    private Ranking dificuldade;

    @JsonIgnore //anotation que faz o json ignorar a serialização dos ninjas, quebra o loop infinito, ninja->missão->ninja->missao
    @OneToMany(mappedBy = "missao")
    private List<Ninja> listaNinjas;

}
