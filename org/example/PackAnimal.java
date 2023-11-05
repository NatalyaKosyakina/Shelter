package org.example;

import java.io.IOException;


public class PackAnimal extends HF {
    private final String type = "PackAnimal";

    protected PackAnimal(int id, String name){
        super(id, name);
    }
    public String gettype() {
        return type;
    }
}
