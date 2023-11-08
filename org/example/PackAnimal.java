package org.example;

import java.io.IOException;
import java.util.Date;
import java.util.List;


public class PackAnimal extends HF {
    private final String type = "PackAnimal";

    protected PackAnimal(int id, String name){
        super(id, name);
    }
    public PackAnimal(int id, String name, Date birthdate, Commands commands) {
        super(id, name, birthdate, commands);
    }
    public String gettype() {
        return type;
    }
}
