package dev.java10x.cadastroDeNinjas.Ninjas.dto;

import dev.java10x.cadastroDeNinjas.Missao.Model.Missao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private Long idade;
    private String aldeia;
    private String ranking;
    String imgUrl;
    private Missao missao;

}
