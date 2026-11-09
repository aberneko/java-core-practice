package arrays;

import java.util.Scanner;

public class InteractiveExpenseTracker {

    void main() {

        double[] expenses = new double[7];

        double expense = 50;

        for (int i = 0; i < expenses.length; i++) {
            expenses[i] = expense;
            expense = expense + 100;
        }
        System.out.print("Расходы за неделю успешно занесены в приложение!\n");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Расходы за какой день вы хотите проверить. Выберите значение от 0 (пн) до 6 (вс).\n");
            int index = scanner.nextInt();
            if (index < 0 || index >= expenses.length) {
                System.out.println("Вы введи несуществующий индекс!\n");
            } else {
                System.out.print("Потрачено " + expenses[index] +" рублей\n");
                break;
            }
        }

    }

}
