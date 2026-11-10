package collectionsframework.iterable.collection.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.IO.println;

public class HashSetDemo {

    // Конструкторы
    private static Set<String> cards = new HashSet<>(); // обычное пусстое множество
    private static Set<String> setCollection = new HashSet<>(); //  Collection<? extends E> c // создать на основе имеющего списка
    private static Set<String> setCapasityLoadFactor = new HashSet<>(16, 0.75f);


    static void main() {
        cards.add("3456 4324 5676 1111"); // возвращает boolean: true or false
        cards.add("3456 4324 5676 3333");
        cards.add("3456 4324 5676 4444");
        cards.add("3456 4324 5676 5555");
        cards.add("3456 4324 5676 6666");

        String number = numberCards();
        println("Номер карты: " + number + "; Cвободен? - " + (cards.contains(number) ? "Нет" : "Да"));

        println(cards);
        println("Размер: " + cards.size());

        List<String> carsStudents = new ArrayList<>();
        carsStudents.add("5454 4324 5676 1111");
        carsStudents.add("7676 4324 5676 1111");
        carsStudents.add("8787 4324 5676 1111");
        carsStudents.add("8999 4324 5676 1111");
        boolean adding = carsStudents.add("3456 4324 5676 6666");// недобавит так как такой номер уже есть

        println("Добавляем элементы из carsStudents в cards: ");
        if(adding) {
            println("3456 4324 5676 6666 уже есть");
        } else {
            println("Добавился");
        }
        cards.addAll(carsStudents); // Collection(? extends E);
        println(cards);
        println("Размер после добавления: " + cards.size());





    }

    public static String numberCards(){
        return "3456 4324 5676 1111";
    }


}
