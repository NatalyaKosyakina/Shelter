package org.example.AnimalClasses;

import org.example.Commands;
import org.example.Pet;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Cat extends Pet {
    private String specie = "Cat";
    public Cat(int id, String name){
        super(id, name);
    }
    public Cat(int id, String name, Date birthdate, Commands commands) {
        super(id, name, birthdate, commands);
    }


    @Override
    public String getSpecie() {
        return specie;
    }
}
