package dev.java10x.cadastroDeNinjas.Ninjas.mapper;


import dev.java10x.cadastroDeNinjas.Ninjas.Model.Ninja;
import dev.java10x.cadastroDeNinjas.Ninjas.dto.NinjaDTO;

public class NinjaMapper {

    public static Ninja toEntity(NinjaDTO ninjaDTO){

        if (ninjaDTO == null) {
            return null;
        }

        return new Ninja(
                ninjaDTO.getId(),
                ninjaDTO.getNome(),
                ninjaDTO.getEmail(),
                ninjaDTO.getIdade(),
                ninjaDTO.getAldeia(),
                ninjaDTO.getRanking(),
                ninjaDTO.getMissao()
        );
    }

    public static NinjaDTO toDTO(Ninja ninja) {

        if (ninja == null) {
            return null;
        }

        return new NinjaDTO(
                ninja.getId(),
                ninja.getNome(),
                ninja.getEmail(),
                ninja.getIdade(),
                ninja.getAldeia(),
                ninja.getRanking(),
                ninja.getMissao()
        );
    }


}
