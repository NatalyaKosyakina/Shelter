package org.example.AnimalClasses;

import org.example.Commands;
import org.example.Pet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Dog extends Pet {
    private String specie = "Dog";

    public Dog(int id, String name){
        super(id, name);
    }
    public Dog(int id, String name, Date birthdate, Commands commands) {
        super(id, name, birthdate, commands);
    }

    public String getSpecie() {
        return specie;
    }
}
