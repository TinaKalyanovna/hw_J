package HW_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
    private final HashMap<String, List<String>> contacts;

    public PhoneBook(){
        contacts = new HashMap<>();
    }

    public void add(String name, String number){
        List<String> numbers;
        if (contacts.containsKey(name)){
            numbers = contacts.get(name);
        } else {
            numbers = new ArrayList<>();
            contacts.put(name,numbers);
        }

        numbers.add(number);
    }
    public void list(){
        for (String name : contacts.keySet()) {
            System.out.print(name + ": ");
            System.out.println(contacts.get(name));
        }
    }
    public void get(String name){
        if (contacts.containsKey(name)) {
//  List<String> numbers = contacts.get(name);
            System.out.println(name +": " + contacts.get(name));
        } else {
            System.out.println("Имя " + name + " не найдено");
        }
    }
    public void remove(String name){
        if(contacts.containsKey(name)){
            contacts.remove(name);
        } else {
            System.out.println("Имя " + name + " не найдено");
        }
    }

    public static String[] parse(String[] str){
        String[] parseTxt = {"",""};
        for (String txt : str) {
            if (!isDigit(txt)){
                parseTxt[0] += txt + " ";
            } else {
                parseTxt[1] += txt + " ";
            }
        }
        parseTxt[0] = parseTxt[0].substring(0, parseTxt[0].length()-1);
        if (parseTxt[1].length() > 0) parseTxt[1] = parseTxt[1].substring(0, parseTxt[1].length()-1);

        return parseTxt;
    }

    public static boolean isDigit(String str){
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        String[] textIn;
        while (true){
            System.out.print("> ");
            String  txt = scanner.nextLine();
            String [] text = txt.split(" ");
            String command = text[0];
            if (command.equalsIgnoreCase("add")){
                textIn = parse(Arrays.copyOfRange(text,1, text.length));
                phoneBook.add(textIn[0],textIn[1]);
            } else if (command.equalsIgnoreCase("get")) {
                textIn = parse(Arrays.copyOfRange(text,1, text.length));
                phoneBook.get(textIn[0]);
            } else if (command.equalsIgnoreCase("list")) {
                phoneBook.list();
            } else if (command.equalsIgnoreCase("remove")) {
                textIn = parse(Arrays.copyOfRange(text,1, text.length));
                phoneBook.remove(textIn[0]);
            } else if (command.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println(command + " неверная команда\nADD name number - добавить в справочник новое значение" +
                        "\nGET name - получить список всех номеров по имени\nLIST - Посмотреть все записи" +
                        "\nREMOVE name- удалить все номера по имени\nEXIT - Завершить программу");
            }

        }
    }
}
