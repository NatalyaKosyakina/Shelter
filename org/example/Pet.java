package org.example;


import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Pet extends HF {
    private String type = "Pet";

    protected Pet(int id, String name){
        super(id, name);
    }
    public Pet(int id, String name, Date birthdate, Commands commands) {
        super(id, name, birthdate, commands);
    }
    public String gettype() {
        return type;
    }
}
