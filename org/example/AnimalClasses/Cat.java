package org.example.AnimalClasses;

import org.example.Pet;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.List;

public class Cat extends Pet {
    private int id;
    private String name;
    private String specie;
    private List<String> comands;
    public Cat(String name)throws IOException {
        super(name);
        this.specie = "Cat";
    }
}
