package arithmetic;

import java.util.Scanner;

public class DivisionExample {
    void main() {

        double a = 5;
        double b = 0;

        System.out.println(a/b); // вернёт бесконечность

        int c = 1;
        int n = 0;

        System.out.println(c/n); // java.lang.ArithmeticException: / by zero

    }
}

class PizzaCalculator {
    void main() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("На сколько кусков порезана пицца?");
        int slicesInPizza = scanner.nextInt();
        System.out.println("Сколько кусков съедает один участник встречи?");
        int slicesToPerson = scanner.nextInt();
        int numOfPizzas = 2;
        int totalSlices = numOfPizzas * slicesInPizza;                  // общее количество кусков
        System.out.println("totalSlices - " + totalSlices);
        int maximumPeopleToMeeting = totalSlices / slicesToPerson;
        int leftSlices = totalSlices % slicesToPerson;
        System.out.println("Максимальное число участников идеальной встречи: " + maximumPeopleToMeeting);
        System.out.println("Останется кусков пиццы: " + leftSlices);

    }
}

class TypeCasting {
    void main() {

        int numberOne = 4;
        int numberTwo = 5;

        double sum = (double) numberTwo / numberOne; // что бы получить полное значение нужно, что бы хотя бы один из них был приведён к старшему типу
        System.out.println(sum);

        double numberTree = 5.5;
        // int numberFour = numberTree; // ошибка
        int numberFour = (int) numberTree;
        System.out.println(numberFour);

    }
}

class IncrementExample {
    void main() {

        int numberOne = 3;
        int numberTwo = 4;

        System.out.println(numberOne++); // Постфиксная - Инкремент
        System.out.println(++numberOne); // Префиксная - Инкремент

        System.out.println(numberTwo--); // Постфиксная - Декремент
        System.out.println(--numberTwo); // Префиксная - Декремент

    }
}

class DepositCalculator {
    void main() {
        double roubles = 5000; // сумма на счету
        double yearRate = 4; // годовая процентная ставка
        int numOfMonth = 36; // количество месяцев, на который открыт вклад
        int monthRefill = 1000; // ежемесячное пополнение
        double monthMaintenance = 0.001 * roubles; //плата за обслуживание счёта
        double monthRate = yearRate / 12; // вычислите месячную процентную ставку
        for (int i = 0; i < numOfMonth; i++) { // дополните условие цикла
            double depositInterest = (monthRate/100) * roubles; // вычислите доход от процентов
            roubles += depositInterest; // добавьте доход от процентов
            roubles = (roubles - monthMaintenance) + monthRefill; // учтите ежемесячное пополнение
        }

        System.out.println("Через " + numOfMonth + " месяцев накопится " + roubles + " рублей");

        if (roubles >= 41000){ // определите, удалось ли достичь цели
            System.out.println("Ура! Можно идти в магазин за новым объективом!");
        } else{
            System.out.println("Нужно ещё немного подкопить.");
        }
    }

}