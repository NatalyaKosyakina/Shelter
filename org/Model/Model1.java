package org.Model;

import org.example.AnimalClasses.*;
import org.example.HF;

import java.io.IOException;
import java.util.HashMap;

public class Model1 implements Model {
    //private String[] listOfSpecies = {"Cat", "Dog", "Hamster", "Horse", "Camel", "Donkey"};

//    public HF addCat(String name){
//        HF cat = null;
//        try {
//            cat = new Cat(name);
//        } catch (IOException e) {
//            e.printStackTrace(); ;
//        }
//        return cat;
//    }

    @Override
    public HF addNewAnimal(String name, int specie)throws IOException{
        int id = -1;
        try {
            id = Counter.add();
        } catch (IOException e){
            throw new IOException(e);
        }
        HF animal = null;
        if (id != -1) {
            switch (specie){
                case (1): animal = new Cat(id, name);
                    break;
                case (2): animal = new Dog(id, name);
                    break;
                case (3): animal = new Hamster(id, name);
                    break;
                case (4): animal = new Horse(id, name);
                    break;
                case (5): animal = new Camel(id, name);
                    break;
                case (6): animal = new Donkey(id, name);
                    break;
                default:
                    break;
            }
        }
        return animal;
    }
}
