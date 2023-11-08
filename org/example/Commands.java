package org.example;

import java.util.ArrayList;

public class Commands {
    ArrayList<String> commands;

    public Commands(){
        this.commands = new ArrayList<>();
    }

    public void add(String newCommand){
        commands.remove("null");
        commands.add(newCommand);
    }

    public void remove(String note){
        commands.remove(note);
    }

    @Override
    public String toString() {
        String result = "";
        for (String note: commands) {
            result += " " + note;
        }
        return result;
    }
}
