package org.example;

import org.Model.Counter;
import org.Model.FileWork;
import org.View.View;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class Presenter {
    View view;
    Support support;
    private final String dateFormat = "yyyy-MM-dd";

    Presenter(View view, Support support){
        this.view = view;
        this.support = support;
    }

    public void selectDoing(){
        boolean flag = true;
        while (flag) {
            String info = view.getInfoFromUser("Выберите действие: \n 1 Найти животное \n " +
                    "2 Показать весь список \n 3 Добавить новую запись о животном\n " +
                    "4 Список по дате рождения \n 0 Выход");
            switch (info) {
                case ("1"):
                    HF found = findAnimal();
                     if (found != null) {
                     doWithNote(found);}
                    break;
                case("2"):
                    showAll();
                    break;
                case("3"):
                    HF animal = addNewAnimal();
                    if (animal != null) {
                        doWithNote(animal);}
                    break;
                case("4"):
                    // Здесь должен быть вывод списка по дате.
                    try {
                        findByBirthDate();
                    } catch (IOException e) {
                        view.showMessage(e.getMessage());
                    }
                    break;
                case("0"):
                    flag = false;
                    break;
                default:
                    view.showMessage("Нет такого действия");
            }
        }
    }

    private void doWithNote(HF note){
        view.showMessage(note.toString());
        boolean flag = true;
        while (flag) {
            String info = view.getInfoFromUser("Выберите действие: \n 1 Показать информацию о животном \n " +
                    "2 Добавить новую команду \n" +
                    " 3 Указать дату рождения \n" +
                    " 0 Вернуться в общее меню");
            switch (info) {
                case ("1"):
                    view.showMessage(note.toString());
                    break;
                case("2"):
                    addCommand(note);
                    try {
                        FileWork fw = new FileWork();
                        fw.changeInfo(String.valueOf(note.getId()), note.toString());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case("3"):
                    try {
                        setBirthDate(note);
                        FileWork fw = new FileWork();
                        fw.changeInfo(String.valueOf(note.getId()), note.toString());
                    } catch (ParseException | IOException e) {
                        view.showMessage(e.getMessage());
                    }
                    break;
                case("0"):
                    flag = false;
                    break;
                default:
                    view.showMessage("Нет такого действия");
            }
        }
    }

    private HF addNewAnimal(){
        String name = view.getInfoFromUser("Укажите имя животного");
        int specie = view.selectSpecie();
        HF animal = null;
        int id = -1;
        try {
            Counter.add();
            id = Counter.getCount();
        } catch (IOException e){
            view.showMessage(e.getMessage());
        }
        if (id != -1) {
            animal = support.addNewAnimal(id, name, specie);
            FileWork fw = new FileWork();
            try {
                fw.save(animal);
            } catch (IOException e) {
                view.showMessage(e.getMessage());
            }
            view.showMessage(animal.toString());
        }
        return animal;
    }
    private void addCommand(HF animal){
        String info = view.getInfoFromUser("Укажите, какую команду научилось выполнять животное");
        animal.addCommand(info);
    }
    private void showAll(){
        FileWork fw = new FileWork();
        try {
            view.showMessage(fw.showAll());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private HF findAnimal(){
        String name = view.getInfoFromUser("Укажите ID или кличку животного");
        int number = view.selectSpecie();
        String specie = "null";
        switch (number) {
            case (1): specie = "Cat";
                break;
            case (2): specie = "Dog";
                break;
            case (3): specie = "Hamster";
                break;
            case (4): specie = "Horse";
                break;
            case (5): specie = "Camel";
                break;
            case (6): specie = "Donkey";
                break;
            default:
                break;
        }
        FileWork fw = new FileWork();
        List<String> notes = fw.findAnimal(specie, name);
        HF animal = null;
        if (notes.isEmpty()) {
            view.showMessage("Записей не найдено");
        } else if (notes.size() == 1) {
            try {
                animal = support.convertToHF(notes.get(0), dateFormat) ;
            } catch (ParseException e) {
                view.showMessage(e.getMessage());
            }
        } else {
            view.showMessage("Найдено несколько вариантов: \n");
            view.showMessage(notes.toString());
            String some = view.getInfoFromUser("Какой вариант выбрать? Укажите ID");
            try {
                if (fw.findByID(some) != null) {
                    animal = support.convertToHF(fw.findByID(some), dateFormat);
                }
            } catch (IOException | ParseException ex) {
                view.showMessage(ex.getMessage());
            }
        }
        return animal;
    }

    private void findByBirthDate() throws IOException {
        FileWork fw = new FileWork();
        List<String> notes = fw.findAnimal(view.getBirthDate(dateFormat));
        if (notes.isEmpty()) {
            view.showMessage("Записей не найдено");
        } else {
            for (String note: notes) {
                view.showMessage(note);
            }
        }
    }
    private void setBirthDate(HF animal) throws ParseException{
        try {
            support.setBirthDate(animal, view.getBirthDate(dateFormat));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
