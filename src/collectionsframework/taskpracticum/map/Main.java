package collectionsframework.taskpracticum.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    // Пример списка пассажиров (на самом деле их больше)
    private static List<String> passengerNames = List.of(
            "Василий Петров",
            "Анна Ягирская",
            "Виктория Сотова",
            "Игорь Серов",
            "Людмила Ульянова"
    );

    public static void main(String[] args) {
        Map<String, Integer> seats = assignSeats(passengerNames);
        Map<String, Integer> seats2 = new TreeMap<>(seats);
        System.out.println("Места пассажиров: " + seats2);
    }

    public static Map<String, Integer> assignSeats(List<String> passengerNames) {

        Map<String, Integer> seats = new HashMap<>();
        int seat = 1;
//        for (int i = 0; i < passengerNames.size(); i++) {
//            String name = passengerNames.get(i);
//            seats.put(name, i + 1);
//        }

        for (String name : passengerNames) {
            seats.put(name, seat);
            seat++;
        }

        return seats;
    }

}
