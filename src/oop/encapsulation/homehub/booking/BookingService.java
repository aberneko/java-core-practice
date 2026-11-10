package oop.encapsulation.homehub.booking;

import oop.encapsulation.homehub.model.BedAndBreakfast; // импортируйте классы BedAndBreakfast и Scanner

import java.util.Scanner;

public class BookingService {

    public static void main(String[] args) {
        // можно забронировать одну из комнат
        BedAndBreakfast hotel = new BedAndBreakfast();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Что вы хотите сделать?");
            System.out.println("1 - Забронировать номер");
            System.out.println("2 - Освободить номер");
            System.out.println("3 - Проверить наличие свободных номеров");
            System.out.println("0 — Выход");

            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    hotel.book();
                    break;
                case 2:
                    hotel.free();
                    break;
                case 3:
                    if (hotel.isFull()) {
                        System.out.println("Больше нет мест¯\\_(ツ)_/¯");
                    } else {
                        System.out.println("Есть свободные номера!");
                    }
                    break;
                case 0:
                    System.out.println("Выход");

                    /* Метод exit() останавливает работу JVM, завершая программу.
                    В качестве аргумента принимает число — код ошибки.
                    Если оно не равно 0 — программа завершилась некорректно.*/
                    System.exit(0); // код равен 0, программа была завершена намеренно
                    // break в этом случае не нужен
                default:
                    System.out.println("Извините, такой команды пока нет.");
                    break;
            }
        }
    }
}
