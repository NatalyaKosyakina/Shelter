package org.example;

import org.View.ConsoleView;

public class Main {
 public static void main(String[] args) {
   Presenter run = new Presenter(new ConsoleView(), new Support());
    run.selectDoing();
 }
 }