package org.example;

import org.Model.Counter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PackAnimal implements HF {
    private int id;
    private String name;
    private String specie;
    private List<String> comands;

    protected PackAnimal(String name) throws IOException {
        this.name = name;
        try {
            this.id = Counter.getCount();
        } catch (IOException e) {
            throw new IOException(e);
        }
    }


    public void addComand(String comand) {
        if (comands == null) {
            comands = new ArrayList<String>();
        }
        comands.add(comand);
    }

    public List<String> getComands() {
        return comands;
    }

}
