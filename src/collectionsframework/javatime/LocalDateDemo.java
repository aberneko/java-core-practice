package collectionsframework.javatime;

import java.time.LocalDate;

public class LocalDateDemo {
    static void main() {
        System.out.println();
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate specificDate = LocalDate.of(2024, 12, 31);
        System.out.println(specificDate);
        System.out.println("год: " + specificDate.getYear());
        System.out.println("число месяца: " + specificDate.getMonthValue());
        System.out.println("день: " + specificDate.getDayOfMonth());
        System.out.println("неделя: " + specificDate.getDayOfWeek().getValue());
        System.out.println("название месяца: " + specificDate.getMonth().toString());
        System.out.println("день недели: " + specificDate.getDayOfWeek().toString());

        System.out.println();
        LocalDate nextWeek = today.plusDays(7);
        System.out.println("Добавли 7 дней: " + nextWeek + ", Старое значение: " + today);
        LocalDate lastMonth = today.minusMonths(1);
        System.out.println("Отняли 1 месяц: " + lastMonth + ", Cтарое значение: " + today);
        LocalDate nextYear = today.plusYears(1);
        System.out.println("Прибавили 1 год: " + nextYear + ", Cтарое значение: " + today);
        LocalDate plusWeeks = today.plusWeeks(2);
        System.out.println("Добивили 2 недели: " + plusWeeks + ", Cтарое значение: " + today);

        System.out.println("Парс строки");
        LocalDate parsedDate = LocalDate.parse("2023-09-17");
        System.out.println(parsedDate);

        LocalDate date1 = LocalDate.of(2023, 1, 1);
        LocalDate date2 = LocalDate.of(2023, 12, 31);

        boolean isBefore = date1.isBefore(date2); // true (1 января раньше 31 декабря)
        boolean isAfter = date1.isAfter(date2);   // false
        boolean isEqual = date1.isEqual(date2);   // false

        LocalDate leap = LocalDate.of(2024, 1, 1);
        boolean isLeap = leap.isLeapYear(); // true (2024 - високосный)
        int daysInMonth = leap.lengthOfMonth(); // 31 (январь)
    }
}
