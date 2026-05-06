package dev.java10x.cadastroDeNinjas.Ninjas.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import dev.java10x.cadastroDeNinjas.Missao.Model.Missao;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "ninja")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = "missoes")
public class Ninja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true, name = "email")
    private String email;

    @Column(name = "idade")
    private Long idade;

    @Column(name = "aldeia")
    private String aldeia;

    @Column(name="ranking")
    private String ranking;

    @ManyToOne
    @JoinColumn(name= "id_missao", nullable = true)
    private Missao missao;



}
