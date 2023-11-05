package org.example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HF {
    private int id;
    private String name;
    private String dateFormat = "yyyy-MM-dd";
    private Date birthdate;
    private List<String> comands;
    private String specie;
    private String type;

    protected HF(int id, String name){
        this.id = id;
        this.name = name;
    }
    public void addCommand(String comand) {
        if (comands == null) {
            comands = new ArrayList<String>();
        }
        comands.add(comand);
    }

    public List<String> getComands() {
        return comands;
    }

    /* Вызов функций нужен для обращения к полям классов - наследников*/
    @Override
    public String toString() {
        String type1 = gettype();
        String specie2 = getSpecie();
        SimpleDateFormat change = new SimpleDateFormat(dateFormat);
        String somedate = change.format(birthdate);
        return id + " " + name + ": "
                + type1 + ", " + specie2 + ", " + somedate + ", команды: " + comands + ". \n";
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

    public String getDateFormat() {
        return dateFormat;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
