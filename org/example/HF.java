package org.example;

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
        String type1 = gettype();
        String specie2 = getSpecie();
        return id + " " + name + ": "
                + type1 + ", " + specie2 + ", команды: " + comands + ". \n";
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getSpecie() {
        return specie;
    }

    public String gettype() {
        return type;
    }
}
