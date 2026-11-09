package loops;

import java.util.Random;
import java.util.Scanner;

// 1. Вложенные циклы (тренировка, сетки квартир)
public class NestedLoopsDemo {
    void main() {
        Scanner scanner = new Scanner(System.in);

        int day = 5; // пять дней
        int number  = 4;
        int carrots = 3;

        for (int i = 1; i <= day; i++) {
            System.out.println("День:" + i);
            for (int j = 1; j <= number; j++) {
                System.out.println("  Пробежка:" + j);
                for (int k = 1; k <= carrots; k++) {
                    System.out.println("    Морковка: " + k);
                }
            }
        }

        System.out.println("-----------------------");

        int flatsNumber = 5; // число квартир
        int floorsNumber = 10; // количество этажей
        for (int i = 1; i <= floorsNumber; i++) {
            for (int j = 1; j <= flatsNumber; j++) {
                int currentFloat = (i - 1) * flatsNumber + j; // формула для подсчёта
                System.out.println("Этаж " + i + " квартира " + currentFloat + "  — доставлено.");
            }
        }

        System.out.println("-----------------------");
        // Программа силовой тренировки в зале
        for (int i = 1; i <= 5; i++) {
            System.out.println("Круг " + i);
            if (i % 2 == 0) {
                for (int j = 1; j <= 5; j++) {
                    System.out.println("Приседание номер " + j);
                }
            } else {
                for (int k = 1; k <= 3; k++) {
                    System.out.println("Отжимание номер " + k);
                }
            }

            for (int m = 1; m <= 7; m++) {
                System.out.println("Пресс номер " + m);
            }
        }
    }
}

// 2. Рисование сетки/прямоугольника из звёздочек
class PatternPrinter {
    void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ширину: ");
        int width = scanner.nextInt();
        System.out.print("Введите высоту: ");
        int height = scanner.nextInt();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("*");
                System.out.print("  ");
            }
            System.out.println();
        }
    }
}

// 3. Калькулятор накоплений через while
class SavingsCalculator {
    void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите сумму ваших сбережений: ");
        int balance = scanner.nextInt();
        int sum = 1000000;
        double total = 0.05;
        int years = 0;

        while (balance < sum) {
            double sum2 = balance * total;
            balance += sum2;
            years++;
        }

        System.out.println("Потребуется лет: " + years);
    }
}

// 4. Игра «Угадай число» с рандомом
class GuessNumberGame {
    void main() {
        System.out.println("-----------------------");
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Я загадал число от 0 до 1000.\n Ваш ход: ");
        int randomInt = random.nextInt(1001);
        int userInput = -1;

        while (userInput != randomInt) {
            userInput = scanner.nextInt();
            if (userInput < randomInt) {
                System.out.println("Больше");
            } else {
                System.out.println("Меньше");
            }
        }

        System.out.println("Вы угадали.");
    }
}

// 5. Управление потоком циклов (break, continue, метки)
class LoopControlDemo {
    void main() {
        while (true) {
            System.out.println("Привет");
            break;
        }
        System.out.println("Пока");

        System.out.println("------------------");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Сколько сегодня бежать: ");
            int steps = scanner.nextInt();

            if (steps == 0) {
                System.out.println("Сегодня пробежка отменяется");
                continue;
            } else if (steps == -1) {
                break;
            }
            System.out.println("Я пробежал " + steps + " шагов");
        }

        System.out.println("------------------");

        mainLoop:
        while (true) {
            while (true) {
                int command = scanner.nextInt();
                if (command == 5) {
                    break mainLoop;
                }
            }
        }

        System.out.println("------------------");

        for (;;) {
            System.out.println("Бесконечный цикл остановлен для безопасности.");
            break;
        }
    }
}

// 6. Демонстрация цикла do-while (выполняется хотя бы 1 раз)
class DoWhileDemo {
    void main() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("--- Меню ---");
            System.out.println("1 - Сделать действие");
            System.out.println("2 - Выход");
            System.out.print("Выберите вариант: ");
            choice = scanner.nextInt();
        } while (choice != 2);

        System.out.println("Выход из do-while выполнен.");
    }
}

// 7. Демонстрация цикла for-each для удобного обхода массивов
class ForEachDemo {
    void main() {
        String[] currencies = {"USD", "EUR", "JPY", "RUB"};

        System.out.println("--- Поддерживаемые валюты ---");
        for (String currency : currencies) {
            System.out.println("Валюта: " + currency);
        }
    }
}