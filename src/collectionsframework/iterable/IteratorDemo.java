package collectionsframework.iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {

    static void main() {
        List<String> list = List.of("dcsd", "cere", "wefe");
        Iterable<String> iterable = new ArrayList<>(List.of("A", "B", "C"));
        Iterator<String> iterator = list.iterator(); // объект-курсор

        while (iterator.hasNext()) { // boolean / есть - нету
            String element = iterator.next(); // возвращаем объект и двигаем курсор
            System.out.print(element + " ");
        }

        list.forEach(s -> System.out.println(s));
    }

}
