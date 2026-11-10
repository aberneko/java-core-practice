package collectionsframework.iterable.collection.sequenced.list;
import static java.lang.IO.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ListDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add(null); // добавленеи в конец
        list.add(null);
        list.add(2, "привет"); // добавление по индесу
        list.remove(0);
        list.addLast(null); // вставка в конце
        list.addFirst("1"); // вставка в начало
        list.remove(0 ); // удление по индексу или значение 
        println(list.get(0)); // получение по индексу
        list.set(0, "2"); // замена по индексу;
        println(list);

        String[] citiesArr = {"Лида", "Минск"};
        list = Arrays.asList(citiesArr); // не копирует а создаёт обёртку над исходным массивом
        // add, remove - нельзя использовать так как у массива фиксированный размер, наследуються на прямую от AbstractList, а там они выбрасывают исключение просто AbstractList
        println(list);
        list.set(1, "Гродно"); // список и массив связаны поэтому если изменить что то в одном поменяется и в другом и наоборот
        println(list);
        println(Arrays.toString(citiesArr));

        List<String> cities = Arrays.asList("Воронеж", "Южно-Сахалинск", "Иркутск"); 
        // add, remove - нельзя использовать так как у массива фиксированный размер
        cities.set(0, "Новгород");
        System.out.println(cities);
        

        List<String> a = Arrays.asList("A", "B");
        List<String> b = List.of("A", "B"); // возвращает специальные скрытые оптимизированные классы
        List<String> c = new ArrayList<>();

        System.out.println(a.getClass().getName()); // java.util.Arrays$ArrayList
        System.out.println(b.getClass().getName()); // java.util.ImmutableCollections$List12
        System.out.println(c.getClass().getName()); // java.util.ArrayList


        List<String> arrayList = List.of("соломка", "картошечка");
        String[] newArray = arrayList.toArray(new String[]{});
        print(arrayList);
        print(Arrays.toString(newArray));
    }
   
}