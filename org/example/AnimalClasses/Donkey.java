package org.example.AnimalClasses;

import org.example.PackAnimal;

import java.io.IOException;
import java.util.List;

public class Donkey extends PackAnimal {
    private String specie = "Donkey";

    public Donkey(int id, String name) {
        super(id, name);
    }

    public String getSpecie() {
        return specie;
    }
}
