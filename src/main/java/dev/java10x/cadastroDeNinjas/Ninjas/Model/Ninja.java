package dev.java10x.cadastroDeNinjas.Ninjas.Model;


import dev.java10x.cadastroDeNinjas.Missao.Model.Missao;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "ninja")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ninja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true)
    private String email;

    private Long idade;
    private String aldeia;

    @ManyToOne
    @JoinColumn(columnDefinition = "id_missao")
    private Missao missao;

}
