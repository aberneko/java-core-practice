package oop.polymorphism.TaskProgram;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваш номер телефона: ");
        String number = scanner.next();
        System.out.print("\nВведите номер собеседника: ");
        String targetNumber = scanner.next();
        System.out.print("\nВыберите модель телефона собеседника: 1. Стационарный телефон, 2 - Мобильный телефон, 3 - Смартфон.");
        int type = scanner.nextInt();

        if(type < 1 || type > 3){
            System.out.println("Введена неверная модель телефона");
            return;
        }

        getPhone(number, type).makeCall(targetNumber);
    }

    public static Phone getPhone(String number, int type){
        if (type == 1){
            return new LandlinePhone(number);
        } else if(type == 2){
            return new MobilePhone(number);
        } else {
            return new Smartphone(number);
        }
    }

}
