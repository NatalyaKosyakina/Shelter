package org.example.AnimalClasses;

import org.example.Pet;

import java.io.IOException;
import java.util.List;

public class Dog extends Pet {
    private String specie = "Dog";

    public Dog(int id, String name){
        super(id, name);
    }

    public String getSpecie() {
        return specie;
    }
}
