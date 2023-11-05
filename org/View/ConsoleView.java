package org.View;

import java.util.Scanner;

public class ConsoleView implements View{
    @Override
    public String getInfoFromUser(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
        //scanner.close();
        return info;
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    public int selectSpecie(){
        boolean flag = true;
        int info = -1;
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("Какое животное нужно добавить? " +
                    "Выберите номер варианта: \n 1 Cat \n 2 Dog \n " +
                    "3 Hamster \n 4 Horse \n 5 Camel \n 6 Donkey");
            info = Integer.parseInt(scanner.nextLine());
            System.out.println("Выполняется");
            if (info >= 1 && info <= 6) {
                flag = false;
            }
        }
        return info;
    }

}
