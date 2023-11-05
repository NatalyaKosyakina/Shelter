package org.example;

import org.Model.Counter;
import org.Model.Model;
import org.View.View;

import java.io.IOException;

public class Presenter {
    View view;
    Model model;

    Presenter(View view, Model model){
        this.view = view;
        this.model = model;
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
            animal = model.addNewAnimal(id, name, specie);
            view.showMessage(animal.toString());
            view.showMessage(animal.gettype());
        }
    }
    public void addComand(HF animal){
        String info = view.getInfoFromUser("Укажите, какую команду научилось выполнять животное");
        model.addCommand(animal, info);
    }


}
