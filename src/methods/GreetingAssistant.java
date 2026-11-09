package methods;

import java.util.Scanner;

public class GreetingAssistant {
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        welcomeUserByName();
        sayHelloByTime();
        printSuccess();
    }

    public static void welcomeUserByName() {  // scanner параметр метода, в него копируется адрес из main
        System.out.print("Ваше Имя: ");
        String name = scanner.nextLine();
        System.out.println("Рад знакомству - " + name);
    }

    public static void sayHelloByTime() {
        System.out.println("Сколько сейчас времени?");
        System.out.print("Введите часы: ");
        int hour = scanner.nextInt();


        if (hour > 22 || hour < 6) {
            System.out.print("Доброй ночи!");
        } else if (hour > 6 && hour < 12) {
            System.out.print("Доброе утро!");
        } else if (hour > 12 && hour < 18) {
            System.out.print("Доброе день!");
        } else {
            System.out.print("Доброе вечер!");
        }
    }

    public static void printSuccess() {
        System.out.println("У вас уже неплохо получается программировать!");
    }
}

class MovieAnalyzer {
    void main() {
        String highestGrossingFilm = findHighestGrossingFilm();
        System.out.println("Самый кассовый фильм: " + highestGrossingFilm);
    }

    public static String findHighestGrossingFilm() {
        String film1 = "Титаник";
        int income1 = 2194;

        String film2 = "Аватар";
        int income2 = 2810;

        String film3 = "Тёмный рыцарь";
        int income3 = 1084;

        // допишите реализацию метода ниже
        if (income1 > income2 && income1 > income3) {
            return film1;
        } else if (income2 > income3 && income2 > income1) {
            return film2;
        } else {
            return film3;
        }
    }
}

class CurrencyAdvisor {
    void main() {
        System.out.println("Привет");
        doCommand();
    }

    public static void doCommand() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Что вы хотите сделать?");
            System.out.println("1 - Получить совет о покупке евро");
            System.out.println("2 - Получить совет о покупке долларов");
            System.out.println("0 - Выход");
            int command = scanner.nextInt();
            if (command == 1) {
                System.out.println("Если евро стоит меньше 105 рублей - покупайте!");
            } else if (command == 2) {
                System.out.println("Если доллар стоит меньше 95 рублей - покупайте!");
            } else if (command == 0) {
                System.out.println("Выход");
                return;
            }
        }
    }

}


class MathUtils {
    void main() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("Наибольшее из чисел " + a + " и " + b + " = " + findMax(a, b));
        // напишите аналогичный вызов метода findMax для таких пар чисел: 16 и 5, -1 и -7

    }

    public static int findMax(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

}

class ExpenseAnalyzer {
    void main() {
        double[] expenses = {1772.5, 367.0, 120.6, 2150.2, 874.0, 1.0, 1459.4};
        double maxExpense = findMaxExpense(expenses); // вызовите метод и присвойте maxExpense значение его результата
        System.out.println("Самая большая трата недели " + maxExpense);// напишите аналогичный вызов метода findMax для таких пар чисел: 16 и 5, -1 и -7

    }

    public static double findMaxExpense(double[] good) {
        double maxExpense = 0;
        for (int i = 0; i < good.length; i++) {
            if (maxExpense < good[i]) {
                maxExpense = good[i];
            }
        }
        return maxExpense;
    }
}

class ExpenseAnalyzer2 {

    void main() {

        double[] feedExpensesCat = {100.50, 236.0, 510.6, 150.20, 80.0, 172.0, 135.4};
        double[] feedExpensesHamster = {70.50, 146.0, 710.6, 250.20, 83.0, 19.0, 55.4};

        String cat = "Пиксель";
        String hamster = "Байт";

        sayHello(cat);
        System.out.println("Твой самый дорогой корм стоил " + findMaxExpense(feedExpensesCat));
        System.out.println("Всего на корм было потрачено " + findExpensesSum(feedExpensesCat));
        sayEnjoyMeal(cat);

        sayHello(hamster);
        System.out.println("Твой самый дорогой корм стоил " + findMaxExpense(feedExpensesHamster));
        System.out.println("Всего на корм было потрачено " + findExpensesSum(feedExpensesHamster));
        sayEnjoyMeal(hamster);

    }

    public static void sayHello(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static double findMaxExpense(double[] feedExpenses) {
        double maxFeedExpense = 0;
        for (int i = 0; i < feedExpenses.length; i++) {
            if (feedExpenses[i] > maxFeedExpense) {
                maxFeedExpense = feedExpenses[i];
            }
        }
        return maxFeedExpense;
    }

    public static double findExpensesSum(double[] feedExpenses) {
        double sumFeed = 0;
        for (int i = 0; i < feedExpenses.length; i++) {
            sumFeed = sumFeed + feedExpenses[i];
        }
        return sumFeed;
    }

    public static void sayEnjoyMeal(String name) {
        System.out.println("Приятного аппетита, " + name);
    }
}

class PersonalBudgetApp {
    void main(){
        double[] expenses = new double[7];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Сколько денег у вас осталось до зарплаты?");
        double moneyBeforeSalary = scanner.nextDouble();

        System.out.println("Сколько дней до зарплаты?");
        int daysBeforeSalary = scanner.nextInt();

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                convert(scanner, moneyBeforeSalary);
            } else if (command == 2) {
                getAdvice(moneyBeforeSalary, daysBeforeSalary);
            } else if (command == 3) {
                // перенесите код ниже в метод saveExpense
                // вызовите метод с помощью такой строки:
                // moneyBeforeSalary = saveExpense(scanner, moneyBeforeSalary, expenses);
                moneyBeforeSalary = saveExpense(scanner, moneyBeforeSalary, expenses);
                System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
            } else if (command == 4) {
                printAllExpenses(expenses);
            } else if (command == 5) {
                // перенесите поиск максимальной траты в метод findMaxExpense
                double maxExpense = findMaxExpense(expenses);
                System.out.println("Самая большая сумма расходов на этой неделе составила " + maxExpense + " руб.");
            } else if (command == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    public static double saveExpense(Scanner scanner, double moneyBeforeSalary, double[] expenses) {
        System.out.println("За какой день вы хотите ввести трату: 1-ПН, 2-ВТ, 3-СР, 4-ЧТ, 5-ПТ, 6-СБ, 7-ВС?");
        int day = scanner.nextInt();
        System.out.println("Введите размер траты:");
        double expense = scanner.nextDouble();
        moneyBeforeSalary = moneyBeforeSalary - expense;
        expenses[day - 1] = expenses[day - 1] + expense;
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }

    public static void printAllExpenses(double[] expenses) {
        for (int i = 0; i < expenses.length; i++) {
            System.out.println("День " + (i + 1) + ". Потрачено " + expenses[i] + " рублей");
        }
    }

    public static double findMaxExpense(double[] expenses){
        double maxExpense = 0;
        for (int i = 0; i < expenses.length; i++) {
            if (expenses[i] > maxExpense) {
                maxExpense = expenses[i];
            }
        }
        return maxExpense;
    }


    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Конвертировать валюту");
        System.out.println("2 - Получить совет");
        System.out.println("3 - Ввести трату");
        System.out.println("4 - Показать траты за неделю");
        System.out.println("5 - Показать самую большую сумму расходов за неделю");
        System.out.println("0 - Выход");
    }

    public static void getAdvice(double moneyBeforeSalary, int daysBeforeSalary) {
        if (moneyBeforeSalary < 3000) {
            System.out.println("Сегодня лучше поесть дома. Экономьте, и вы дотянете до зарплаты!");
        } else if (moneyBeforeSalary < 10000){
            if (daysBeforeSalary < 10) {
                System.out.println("Можно заказать пиццу!");
            } else {
                System.out.println("Сегодня лучше поесть дома. Экономьте, и вы дотянете до зарплаты!");
            }
        } else if (moneyBeforeSalary < 30000) {
            if (daysBeforeSalary < 10) {
                System.out.println("Неплохо! Сегодня можно поужинать в кафе.");
            } else {
                System.out.println("Можно заказать пиццу!");
            }
        } else {
            if (daysBeforeSalary < 10) {
                System.out.println("Отлично! Можно сходить в ресторан.");
            } else {
                System.out.println("Неплохо! Сегодня можно поужинать в кафе.");
            }
        }
    }

    public static void convert(Scanner scanner, double moneyBeforeSalary) {
        double rateUSD = 94.8;
        double rateEUR = 103.8;
        double rateCNY = 13.1;

        System.out.println("Ваши сбережения: " + moneyBeforeSalary + " RUB");
        System.out.println("В какую валюту хотите конвертировать? Доступные варианты: 1 - USD, 2 - EUR, 3 - CNY.");
        int currency = scanner.nextInt();
        if (currency == 1) {
            System.out.println("Ваши сбережения в долларах: " + moneyBeforeSalary / rateUSD);
        } else if (currency == 2) {
            System.out.println("Ваши сбережения в евро: " + moneyBeforeSalary / rateEUR);
        } else if (currency == 3) {
            System.out.println("Ваши сбережения в юанях: " + moneyBeforeSalary / rateCNY);
        } else {
            System.out.println("Введена неизвестная валюта.");
        }
    }

}



