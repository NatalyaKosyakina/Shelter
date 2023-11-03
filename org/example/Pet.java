package org.example;

import org.Model.Counter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pet implements HF {
    private int id;
    private String name;
    private String specie;
    private List<String> comands;

    protected Pet(String name) throws IOException {
        this.name = name;
        id = 1;
//        try {
//            this.id = Counter.getCount();
//        } catch (IOException e) {
//            throw new IOException(e);
//        }
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

    @Override
    public String toString() {
        return specie + " " + name +
                ", " + comands + '\'';
    }
}
