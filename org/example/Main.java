package org.example;

import org.Model.Model1;
import org.View.ConsoleView;


public class Main {
 public static void main(String[] args) {
  Presenter run = new Presenter(new ConsoleView(), new Model1());
 run.addNewAnimal();
 }



  //Запросить у пользователя вид животного (на выбор из нескольких вариантов)

  //Запросить имя (Ввод строки)

  //Вызвать запрос ID, создать животное выбранного вида, присвоить ему id, вид и имя.


}