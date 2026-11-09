package conditionals;

import java.util.Scanner;

public class TravelPlanner {
    void main() {

        Scanner scanner = new Scanner(System.in);
        int monthNumber;

        while (true) {
            System.out.println("Когда планируется путешествие? Введите номер месяца от 1 до 12.");
            monthNumber = scanner.nextInt();

            if (monthNumber < 12 && monthNumber > 0) { // Инвертируйте условие
                break;
            } else {
                System.out.println("Некорректный номер месяца. Введите ещё раз.");
            }
        }
        String season = "";
        // Допишите условия ветвления в виде утверждений
        if (monthNumber < 3) {
                 season = "Зима";
        } else if (monthNumber < 6) {   
            season = "Весна";
        } else if (monthNumber < 9) {
            season = "Лето";
        } else if (monthNumber < 12) {
            season = "Осень";
        } else {
            season = "Зима";
        }

        if (season.equals("Лето")) {
            System.out.println("Летом лучше остаться в Москве.");
        }

        else {
            System.out.println("Укажите стоимость прямых билетов из Москвы в Париж:");
            int ticketMoscowParis = scanner.nextInt();
            System.out.println("Укажите стоимость билетов из Москвы в Париж с пересадкой в Лондоне:");
            int ticketMoscowLondonParis = scanner.nextInt();
            System.out.println("У вас есть британская виза?");
            System.out.println("1 - да, виза есть");
            System.out.println("0 - визы нет");
            int britainVisa = scanner.nextInt();



            if (ticketMoscowLondonParis <= ticketMoscowParis ) {
                if (britainVisa != 0) { // Упростите это условие
                    System.out.println("Летим через Лондон!");
                } else {
                    System.out.println("Летим напрямую в Париж!");
                }
            } else {
                System.out.println("Летим напрямую в Париж!");
            }

        }

    }
}

class LeapYearChecker {
    void main() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Какой год вы хотите проверить?");
        int year = scanner.nextInt();

        boolean isLeapYear = (year % 400 == 0 || year % 4 == 0) && year % 100 != 0;
        // Составьте логическое выражение
        if (isLeapYear) {
            System.out.println("Согласно григорианскому календарю, этот год - невисокосный!");
        } else {
            System.out.println("Согласно григорианскому календарю, этот год - високосный!");
        }
    }

}

class HistoricalShop {
    void main() {

        String[] items1913 = {"Корова", "Курица", "Рубашка", "Шапка гусарская", "Гармонь", "Рояль"};
        String[] items1984 = {"Банка сгущёнки", "Мороженое", "Карта мира", "Кассетный магнитофон", "Пальто осеннее"};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму в современных рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите год (1913 или 1984)");
        int year = scanner.nextInt();

        // это коэффициент для перевода рубля по курсу заданного года
        double koef = -1;                                                      // это флаг для того что бы если пользователь ввёл год которого нету программа сообщила ему

        switch (year) {
            case 1913:
                koef = 1.0 / 884;
                break;
            case 1984:
                koef = 1.0 / 337;
                break;
        }

        // курс рубля задан не для каждого года
        if(koef < 0){
            System.out.println("Для этого года у нас нет данных.");
            koef = 0;
        }

        // переведите заданную сумму в рубли по старому курсу
        double amountByYear = amount * koef;

        System.out.println("В " + year + " году эта сумма приблизительно равнялась бы "
                + amountByYear + " р. "
                + "На эти деньги вы могли бы купить следующие товары:");

        // выведите товары, которые вам доступны
        switch (year) {
            case 1913:
                for (int i = 0; i < items1913.length; i++) {
                    String item = items1913[i];
                    double price = 0.0;
                    switch (item){
                        case "Корова": price = 60.0;
                            break;
                        case "Курица": price = 0.60;
                            break;
                        case "Рубашка": price = 1.0;
                            break;
                        case "Шапка гусарская": price = 12.0;
                            break;
                        case "Гармонь": price = 7.50;
                            break;
                        case "Рояль": price = 200.0;
                            break;
                    }
                    // рассчитываем количество и приводим результат к целому числу
                    int quantity = (int) (amountByYear / price);
                    if(quantity > 0) {
                        System.out.println(item + " — " + quantity + " шт.");
                    }
                }

                break;
            case 1984:
                for (int i = 0; i < items1984.length; i++) {
                    String item = items1984[i];
                    double price = 0.0;
                    switch (item){
                        case "Банка сгущёнки": price = 0.55;
                            break;
                        case "Мороженое": price = 0.20;
                            break;
                        case "Карта мира": price = 0.54;
                            break;
                        case "Кассетный магнитофон": price = 95.0;
                            break;
                        case "Пальто осеннее": price = 100.0;
                            break;
                    }
                    // рассчитываем количество и приводим результат к целому числу
                    int quantity = (int) (amountByYear / price);
                    if(quantity > 0) {
                        System.out.println(item + " — " + quantity + " шт.");
                    }
                }
                break;
        }
    }
}

class CrosswalkSimulator {
    void main() {

        Scanner scanner = new Scanner(System.in);

        boolean isTrafficLightGreen = false; // эта переменная отвечает за зелёный сигнал светофора

        boolean isVehicleApproaching = false; // эта переменная отвечает за приближающийся транспорт

        System.out.println("Вы находитесь около пешеходного перехода (да/нет)?");
        String onCrosswalk = scanner.nextLine();
        boolean isOnCrosswalk = onCrosswalk.equals("да"); // // эта переменная отвечает за пешеходный переход, проверьте, ответил ли пользователь утвердительно

        if (isOnCrosswalk) {
            // Если пешеход находится на пешеходном переходе:
            System.out.println("Горит ли зелёный сигнал светофора (да/нет)?");
            String trafficLightGreen = scanner.nextLine();
            isTrafficLightGreen = trafficLightGreen.equals("да");
            if (!isTrafficLightGreen){
                // Если светофор красный:
                System.out.println("Не переходите дорогу на красный свет светофора!");
            }
        } else {
            // Если к пешеходу приближается транспортное средство:
            System.out.println("Видите ли вы приближающиеся автомобили (да/нет)?");
            String vehicleApproaching = scanner.nextLine();
            isVehicleApproaching = vehicleApproaching.equals("да");
            if (isVehicleApproaching) {
                System.out.println("Дождитесь, пока проедет транспортное средство!");
            }
        }

        boolean isSafePlace = false; // эта переменная отвечает за то, безопасное ли место перехода

        if(!isOnCrosswalk && !isVehicleApproaching) {
            // Проверка на перебежку дороги в небезопасном месте:
            System.out.println("Находится ли вблизи вас поворот (П), остановка (А), перекрёсток (Х) или нет?");
            String unsafePlaceType = scanner.nextLine();
            switch (unsafePlaceType) {
                case "П":
                System.out.println("Не перебегайте дорогу вблизи поворотов!");
                    break;
                case "Х":
                System.out.println("Не перебегайте дорогу вблизи перекрестков!");
                    break;
                case "А":
                System.out.println("Не перебегайте дорогу вблизи остановок общественного транспорта!");
                    break;
                default:
                    isSafePlace = true;
            }
        }

        if((isOnCrosswalk && isTrafficLightGreen)
                || (!isOnCrosswalk && !isVehicleApproaching && isSafePlace)) {
            System.out.println("Вы можете перейти дорогу!");
            System.out.println("Сколько полос движения на дороге?");
            int linesCount = scanner.nextInt();
            if(linesCount == 1){
                System.out.println("Посмотрите в обе стороны и переходите.");
            } else {
                int halfWay = linesCount / 2;
                for(int line = 1; line <= linesCount; line++){
                    if(line <= halfWay){
                        System.out.println("Посмотрите налево и переходите.");
                    } else {
                        System.out.println("Посмотрите направо и переходите.");
                    }
                }
            }
        } else {
            System.out.println("Вы не можете перейти дорогу в этом месте!");
        }

    }

}

