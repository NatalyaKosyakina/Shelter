package org.example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HF{
    private final int id;
    private String name;
    private final String dateFormat = "yyyy-MM-dd";
    private Date birthdate;
    private Commands commands;
    private String specie;
    private String type;

    private int next;

    protected HF(int id, String name){
        this.id = id;
        this.name = name;
    }
    public void addCommand(String command) {
        if (commands == null) {
            commands = new Commands();
        }
        commands.add(command);
    }

    protected HF(int id, String name, Date birthdate, Commands commands){
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.commands = commands;
    }

    public Commands getComands() {
        return commands;
    }

    /* Вызов функций нужен для обращения к полям классов - наследников*/
    @Override
    public String toString() {
        String type1 = gettype();
        String specie2 = getSpecie();
        String somedate = "null";
        if (birthdate != null){
            SimpleDateFormat change = new SimpleDateFormat(dateFormat);
            somedate = change.format(birthdate);
        }
        String listOfComands = "null";
        if (commands != null) {
            listOfComands = commands.toString();
        }
        return id + " " + name + ": "
                + type1 + ", " + specie2 + ", " + somedate + ", команды: " + listOfComands + " \n";
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
