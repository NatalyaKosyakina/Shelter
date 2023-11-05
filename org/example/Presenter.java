package org.example;

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
        try {
            animal = model.addNewAnimal(name, specie);
            view.showMessage(animal.toString());
        } catch (IOException e) {
           view.showMessage(e.getMessage());
        }
    }
}
