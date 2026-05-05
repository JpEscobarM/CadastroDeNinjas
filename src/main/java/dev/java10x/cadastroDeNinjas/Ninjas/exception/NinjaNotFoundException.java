package dev.java10x.cadastroDeNinjas.Ninjas.exception;

import java.util.NoSuchElementException;

public class NinjaNotFoundException extends NoSuchElementException {

    public NinjaNotFoundException() {
        super("Não foi possível encontrar o ninja indicado.");
    }

    public NinjaNotFoundException(Long id) {
        super("Não foi possível encontrar o ninja ID=" + id );
    }

}
