package org.example.AnimalClasses;

import org.example.Pet;

import java.io.IOException;
import java.util.List;

public class Hamster extends Pet {
    private int id;
    private String name;
    private String specie;
    private List<String> comands;
    protected Hamster(String name) throws IOException {
        super(name);
        this.specie = "Hamster";
    }
}
