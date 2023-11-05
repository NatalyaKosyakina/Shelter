package org.example;

import org.View.ConsoleView;

import java.text.ParseException;


public class Main {
 public static void main(String[] args) {
   Presenter run = new Presenter(new ConsoleView());
  // Не забыть перепесать addNewAnimal на private!
   HF cat = run.addNewAnimal(2, "Anilin", 4);
   run.addCommand(cat);
  try {
   run.setBirthDate(cat);
  } catch (ParseException e) {
   throw new RuntimeException(e);
  }
  System.out.println(cat);
 }



  //Запросить у пользователя вид животного (на выбор из нескольких вариантов)

  //Запросить имя (Ввод строки)

  //Вызвать запрос ID, создать животное выбранного вида, присвоить ему id, вид и имя.


}