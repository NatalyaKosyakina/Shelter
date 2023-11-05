package org.Model;

import org.example.AnimalClasses.*;
import org.example.HF;

public class Model1 implements Model {

    @Override
    public HF addNewAnimal(int id, String name, int specie){
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

    public void addCommand(HF animal, String command){
        animal.addComand(command);
    }
}
