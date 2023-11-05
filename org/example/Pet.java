package org.example;


import java.io.IOException;

public class Pet extends HF {
    private String type = "Pet";

    protected Pet(int id, String name){
        super(id, name);
    }
    public String gettype() {
        return type;
    }
}
