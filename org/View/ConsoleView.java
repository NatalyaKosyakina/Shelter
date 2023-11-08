package org.View;

import java.util.Scanner;

public class ConsoleView implements View{
    @Override
    public String getInfoFromUser(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
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
            System.out.println("Вид животного (укажите номер): \n " +
                    " 1 Cat \n 2 Dog \n 3 Hamster \n 4 Horse \n 5 Camel \n 6 Donkey");
            try {
                String input = scanner.nextLine();
                info = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Неправильный ввод данных");
            }
            if (info >= 1 && info <= 6) {
                flag = false;
            }
        }
        return info;
    }

    public String getBirthDate(String format){
        System.out.printf(" Укажите дату рождения животного в формате %s . \n Год: ", format);
        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
        System.out.println("Месяц: ");
        info = info + "-" + scanner.nextLine();
        System.out.println("День: ");
        info = info + "-" + scanner.nextLine();
        return info;
    }
}
