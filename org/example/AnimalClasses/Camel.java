package org.example.AnimalClasses;

import org.example.Commands;
import org.example.PackAnimal;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Camel extends PackAnimal {
    private String specie = "Camel";

    public Camel(int id, String name){
        super(id, name);
    }
    public Camel(int id, String name, Date birthdate, Commands commands) {
        super(id, name, birthdate, commands);
    }

    public String getSpecie() {
        return specie;
    }
}
