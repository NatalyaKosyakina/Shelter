package org.Model;

import org.example.HF;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    String base = "base.txt";


    public void save(HF animal) throws IOException {
        try (FileWriter writer = new FileWriter(base, true)) {
            writer.append(animal.toString());
            writer.flush();
        }
    }

    public String showAll() throws IOException {
        StringBuilder animals = new StringBuilder();
        try {
            File file = new File(base);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String temp = reader.readLine();
            while (temp != null) {
                animals.append(temp).append("\n");
                temp = reader.readLine();
            }
            reader.close();
            fr.close();
        } catch (IOException e) {
            throw new IOException(e);
        }
        return animals.toString();
    }

    public List<String> findAnimal(String specie, String name){
        List<String> result = new ArrayList<>();
        try {
            File file = new File(base);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String animal = reader.readLine();
            while (animal != null) {
                if (animal.contains(name) && animal.contains(specie)) {
                    result.add(animal);
                }
                animal = reader.readLine();
            }
            reader.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<String> findAnimal(String birthDate) throws IOException {
        List<String> result = new ArrayList<>();
        try {
            File file = new File(base);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String animal = reader.readLine();
            while (animal != null) {
                if (animal.contains(birthDate)) {
                    result.add(animal);
                }
                animal = reader.readLine();
            }
            reader.close();
            fr.close();
        } catch (IOException e) {
            throw new IOException("Не удалось открыть файл");
        }
        return result;
    }

    public String findByID(String id) throws IOException{
        String result = "not found";
        try {
            File file = new File(base);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String animal = reader.readLine();
            while (animal != null) {
                if (animal.contains(id)){
                    String[] temp = animal.split(" ");
                    if (temp[0].equals(id)) {
                        result = animal;
                        break;
                    }
                }
                animal = reader.readLine();
            }
            reader.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException("Не удалось открыть файл");
        }
        return result;
    }
    public void changeInfo(String id, String newInfo) throws IOException {
        StringBuilder animals = new StringBuilder();
        try {
            File file = new File(base);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String temp = reader.readLine();
            while (temp != null) {
                if (temp.contains(id)) {
                    String[] temp1 = temp.split(" ");
                    if (temp1[0].equals(id)) {
                        animals.append(newInfo);
                    }
                } else {
                    animals.append(temp).append("\n");
                }
                temp = reader.readLine();
            }
            reader.close();
            fr.close();
        } catch (IOException e) {
            throw new IOException(e);
        }
        try (FileWriter writer = new FileWriter(base, false)) {
            writer.append(animals.toString());
            writer.flush();
        }
    }


}
