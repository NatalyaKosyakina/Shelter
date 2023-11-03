package org.example.AnimalClasses;

import org.example.PackAnimal;

import java.io.IOException;
import java.util.List;

public class Donkey extends PackAnimal {
    private int id;
    private String name;
    private String specie;
    private List<String> comands;
    protected Donkey(String name) throws IOException {
        super(name);
        this.specie = "Donkey";
    }
}
