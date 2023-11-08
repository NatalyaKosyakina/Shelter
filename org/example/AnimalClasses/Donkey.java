package org.example.AnimalClasses;

import org.example.Commands;
import org.example.PackAnimal;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Donkey extends PackAnimal {
    private String specie = "Donkey";

    public Donkey(int id, String name) {
        super(id, name);
    }
    public Donkey(int id, String name, Date birthdate, Commands commands) {
        super(id, name, birthdate, commands);
    }

    public String getSpecie() {
        return specie;
    }
}
