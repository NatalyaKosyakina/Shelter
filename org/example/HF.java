package org.example;

import org.Model.Counter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HF {
    private int id;
    private String name;
    private Date birthdate;
    private List<String> comands;
    private String specie;
    private String type;

    protected HF(int id, String name){
        this.id = id;
        this.name = name;
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
        return id + " " + name + ": "
                + type + ", " + specie + ", команды: " + comands + ". \n";
    }
}
