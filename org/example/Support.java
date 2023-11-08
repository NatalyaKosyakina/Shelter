package org.example;

import org.example.AnimalClasses.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Support {

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
    public void setBirthDate(HF animal, String birthDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(animal.getDateFormat());
        Date birthdate = null;
        try {
            birthdate = formatter.parse(birthDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        animal.setBirthdate(birthdate);

    }

    public HF convertToHF(String note, String dateFormat)throws ParseException{
        String[] temp = note.split(": ");
        String[] block1 = temp[0].split(" ");
        int id = Integer.parseInt(block1[0]);
        String name = block1[1];
        String[] block2 = temp[1].split(", ");
        String specie = block2[1];
        Date birthdate = null;
        if (!block2[2].equals("null")){
            SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
            try {
                birthdate = formatter.parse(block2[2]);
            } catch (ParseException e) {
                throw new RuntimeException("Что-то не так с записью о дате рождения животного");
            }
        }
        Commands commands = getCommands(temp);
        HF animal = null;
        switch (specie){
            case ("Cat"): animal = new Cat(id, name, birthdate, commands);
                break;
            case ("Dog"): animal = new Dog(id, name, birthdate, commands);
                break;
            case ("Hamster"): animal = new Hamster(id, name, birthdate, commands);
                break;
            case ("Horse"): animal = new Horse(id, name, birthdate, commands);
                break;
            case ("Camel"): animal = new Camel(id, name, birthdate, commands);
                break;
            case ("Donkey"): animal = new Donkey(id, name, birthdate, commands);
                break;
            default:
                break;
        }
        return animal;
    }

    private Commands getCommands(String[] temp) {
        Commands commands = new Commands();
        if (!temp[2].equals("null.")){
            String[] temp1 = temp[2].split(" ");
            for (String s : temp1) {
                if (s.contains(", ")) {
                    String[] temp2 = s.replace("[", "").
                            replace("]", "").split(", ");
                    for (String t: temp2) {
                        commands.add(t.strip());
                    }
                } else {
                    commands.add(s.strip());
                }
            }
        }
        return commands;
    }
}
