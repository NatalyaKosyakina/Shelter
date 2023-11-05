package org.Model;

import org.example.HF;

import java.io.IOException;

public interface Model {
    public HF addNewAnimal(String name, int specie) throws IOException;
}
