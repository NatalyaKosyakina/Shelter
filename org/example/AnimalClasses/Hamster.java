package org.example.AnimalClasses;

import org.example.Commands;
import org.example.Pet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Hamster extends Pet {
    private String specie = "Hamster";

    public Hamster(int id, String name){
        super(id, name);
    }
    public Hamster(int id, String name, Date birthdate, Commands commands) {
        super(id, name, birthdate, commands);
    }

    public String getSpecie() {
        return specie;
    }
}
