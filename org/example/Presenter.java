package org.example;

import org.Model.Counter;
import org.View.View;
import org.example.AnimalClasses.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Presenter {
    View view;

    Presenter(View view){
        this.view = view;
    }

    public void addNewAnimal(){
        String name = view.getInfoFromUser("Укажите имя животного");
        int specie = view.selectSpecie();
        HF animal = null;
        int id = -1;
        try {
            Counter.add();
            id = Counter.getCount();
        } catch (IOException e){
            view.showMessage(e.getMessage());
        }
        if (id != -1) {
            animal = addNewAnimal(id, name, specie);
            view.showMessage(animal.toString());
        }
    }
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
    public void addCommand(HF animal){
        String info = view.getInfoFromUser("Укажите, какую команду научилось выполнять животное");
        animal.addCommand(info);
    }

    public void setBirthDate(HF animal) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat(animal.getDateFormat());
        Date birthdate = null;
        try {
            birthdate = formatter.parse(view.getBirthDate(animal.getDateFormat()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        animal.setBirthdate(birthdate);
    }
}
