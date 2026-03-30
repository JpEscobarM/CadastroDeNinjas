package dev.java10x.cadastroDeNinjas.Ninjas.Model;


import dev.java10x.cadastroDeNinjas.Missao.Model.Missao;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ninja")
public class Ninja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private Long idade;
    private String aldeia;
    private List<Missao> listaMissoes;

    public Ninja() {
    }

    public Ninja(String nome, String email, Long idade, String aldeia) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.aldeia = aldeia;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Long getIdade() {
        return idade;
    }

    public String getAldeia() {
        return aldeia;
    }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdade(Long idade) {
        this.idade = idade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAldeia(String aldeia) {
        this.aldeia = aldeia;
    }
}
