package org.Model;

import org.example.HF;

import java.io.IOException;

public interface Model {
    public HF addNewAnimal(int id, String name, int specie);
    public void addCommand(HF animal, String command);
}
