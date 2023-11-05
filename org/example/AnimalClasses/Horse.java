package org.example.AnimalClasses;

import org.example.PackAnimal;

import java.io.IOException;
import java.util.List;

public class Horse extends PackAnimal {
    private String specie = "Horse";

    public Horse(int id, String name){
        super(id, name);
    }

    public String getSpecie() {
        return specie;
    }
}
