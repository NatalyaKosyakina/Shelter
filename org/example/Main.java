package org.example;


import org.example.AnimalClasses.Cat;

import java.io.IOException;

public class Main {
 public static void main(String[] args) {
  Cat cat = null;
  try {
   cat = new Cat("Barsik");
  } catch (IOException e) {
   e.printStackTrace(); ;
  }
  System.out.println(cat);
 }
}