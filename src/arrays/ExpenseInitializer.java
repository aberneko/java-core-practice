package arrays;

public class ExpenseInitializer {

    void main() {

        double[] expenses = new double[7]; // объявили массив трат за неделю (7 дней)

        int expense = 50; // в первый день потрачено 50 рублей

        // заполнили массив, используя цикл for
        for (int i = 0; i < expenses.length; i++) {
            expenses[i] = expense;
            expense += 100;
            System.out.print(" " + expense);
        }
        System.out.println(" Ошибок нет. Все расходы успешно занесены в приложение!");

    }

}
