package oop.polymorphism.TaskProdram2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        List<Multiplatform> multi = new ArrayList<>();

        while (true){
            print();
            int count = scanner.nextInt();

            switch (count) {
                case 1:
                    System.out.print("Введите название фильма: ");
                    String title = scanner.next();
                    System.out.print("Введите продолжительность фильма (мин): ");
                    double runtime = scanner.nextDouble();
                    Movie movie = new Movie(runtime, title);
                    multi.add(movie);
                    break;
                case 2:
                    System.out.print("Введите название сериала: ");
                    String titleSeries = scanner.next();
                    System.out.print("Введите среднюю продолжительность серии (мин): ");
                    double runtimeSeries = scanner.nextDouble();
                    System.out.print("Введите количество серий: ");
                    int countSeries = scanner.nextInt();
                    Series series = new Series(runtimeSeries, titleSeries, countSeries);
                    multi.add(series);
                    break;
                case 0:
                    System.out.println("Ваши фильмы и сериалы: ");
                    printAll(multi);
                    double totalDays = Calculator.calculate(multi);
                    System.out.println("Количество дней для просмотра вашей библиотеки " + totalDays);
                    break;
                default:
                    System.out.println("Такого варианта нет, повторите попытку!");
            }
        }
    }

    public static void print(){
        System.out.println("Выберите действие: ");
        System.out.println("1. Добавить фильм");
        System.out.println("2. Добавить сериал");
        System.out.println("0. Посчитать время в днях и выйти");
    }

    public static void printAll(List<Multiplatform> multi){
        for (Multiplatform m : multi){
            System.out.println(" /- " + m.getTitle() + " -/ ");
        }
    }

}
