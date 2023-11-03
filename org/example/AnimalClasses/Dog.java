package org.example.AnimalClasses;

import org.example.Pet;

import java.io.IOException;
import java.util.List;

public class Dog extends Pet {
    private int id;
    private String name;
    private String specie;
    private List<String> comands;

    protected Dog(String name) throws IOException {
        super(name);
        this.specie = "Dog";
    }
}
