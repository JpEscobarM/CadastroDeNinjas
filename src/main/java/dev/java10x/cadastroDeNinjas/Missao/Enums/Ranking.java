package dev.java10x.cadastroDeNinjas.Missao.Enums;

public enum Ranking {

    D("Baixo",2),
    C("Baixo",3),
    B("Médio",4),
    A("Alto",10),
    S("Dificil",15);

    private String descrição;
    private int dificuldade;


    Ranking(String descrição, int dificuldade) {
        this.descrição = descrição;
        this.dificuldade = dificuldade;
    }
}
