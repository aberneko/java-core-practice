package constants;

import java.util.Scanner;

public class ConstantaDemo {

     static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Пожалуйста, введите сумму перевода в рублях.");
        double amount = scanner.nextDouble();

        boolean isValid = TransactionValidator.isValidAmount(amount);
        if (isValid) {
            System.out.println("Спасибо! Ваш перевод на сумму " + amount + " р. успешно выполнен.");
        }
    }

}

class TransactionValidator {

    final static int MIN_AMOUNT = 1;
    final static int MAX_AMOUNT = 5000;

    static boolean isValidAmount(double amount){
        if(amount > MAX_AMOUNT){
            System.out.println("Максимальная сумма перевода: " + MAX_AMOUNT + " р. Попробуйте ещё раз!");
            return false;
        } else if (amount <  MIN_AMOUNT){
            System.out.println("Минимальная сумма перевода: " + MIN_AMOUNT + " р. Попробуйте ещё раз!");
            return false;
        } else {
            return true;
        }

    }
}