package collectionsframework.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;


public class LinkedHashMapDemo {

    static void main() {
        int initialCapacity = 16;
        float loadFactor = 0.75f; //  жесткими ограничениями по памяти
        boolean accessOrder = true; //  мапа начинает переставлять элементы в конец при каждом get()
        LinkedHashMap<Integer, String> linkedHashMapEmpty = new LinkedHashMap<>(); //  16 ячеек, loadFactor 0.75, порядок добавления (accessOrder = false
        LinkedHashMap<Integer, String> linkedHashMapSize = new LinkedHashMap<>(initialCapacity); // место под initialCapacity элементов
        LinkedHashMap<Integer, String> linkedHashMapSizeCapacity = new LinkedHashMap<>(initialCapacity, loadFactor); // расширяйся, когда заполнишься на X процентов
        LinkedHashMap<Integer, String> linkedHashMapSizeCapacityOrder = new LinkedHashMap<>(initialCapacity, loadFactor, accessOrder); // расширяйся, когда заполнишься на X процентов
        LinkedHashMap<Integer, String> linkedHashMapCopyMap = new LinkedHashMap<>(); // Map<? extends K, ? extends V> m - скопировать беспорядочную мапу и создать новую с порядок

        System.out.println("Первый конструктор");
        linkedHashMapEmpty.put(5, "Пять");
        linkedHashMapEmpty.put(1, "Один");
        linkedHashMapEmpty.put(3, "Три");
        System.out.println(linkedHashMapEmpty);

        System.out.println();
        System.out.println("Второй конструктор");
        LinkedHashMap<Integer, String> linkedHashMapSize1 = new LinkedHashMap<>(20);
        for(int i = 0; i < 20; i++){
            linkedHashMapSize1.put(i, " число ");
        }
        System.out.println(linkedHashMapSize1);

        System.out.println();
        System.out.println("Третий конструктор");
        LinkedHashMap<Integer, String> linkedHashMapSizeCapacity1 = new LinkedHashMap<>(16, 0.75f);
        // entrySet = {LinkedHashMap$LinkedEntrySet@1274} «Это представление (View) для перебора мапы. Оно не хранит данные, а содержит ссылку на саму мапу и предоставляет итератор, превращая мапу в Set из объектов Entry (ключ-значение). Это нужно, потому что сама Map не наследуется от Collection и её нельзя перебрать обычным циклом».
        for(int i = 0; i < 16; i++){
            linkedHashMapSizeCapacity1.put(i, " число ");
        }
        System.out.println(linkedHashMapSizeCapacity1);


        System.out.println();
        System.out.println("Четвёртый конструктор");
        LinkedHashMap<Integer, String> linkedHashMapSizeCapacityOrder1 = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMapSizeCapacityOrder1.put(1, "А");
        linkedHashMapSizeCapacityOrder1.put(2, "B");
        linkedHashMapSizeCapacityOrder1.put(3, "C");
        System.out.println(linkedHashMapSizeCapacityOrder1);
        linkedHashMapSizeCapacityOrder1.get(1);
        System.out.println(linkedHashMapSizeCapacityOrder1);
        linkedHashMapSizeCapacityOrder1.get(2);
        System.out.println(linkedHashMapSizeCapacityOrder1);
        linkedHashMapSizeCapacityOrder1.get(3);
        System.out.println(linkedHashMapSizeCapacityOrder1);


        System.out.println();
        System.out.println("Пятый конструктор");
        Map<Integer, String> map = new HashMap<>();
        map.put(23, "Два");
        map.put(12, "Один");
        map.put(3, "Три");
        map.put(47, "Четыре");
        map.put(54, "Пять");

        for(Integer key : map.keySet()) {
            System.out.println(map.get(key));
        }

        System.out.println();
        // Берет любую мапу (например, хаотичную HashMap) и копирует её элементы
        // в том порядке, в котором они лежат в её итераторе (то есть копирует тот же хаос,
        // просто теперь LinkedHashMap его запомнит и не будет менять).
        LinkedHashMap<Integer, String> mapCopy = new LinkedHashMap<>(map);
        for(Integer key : mapCopy.keySet()) {
            System.out.println(mapCopy.get(key));
        }






    }
}

class HashProof {
    static void main() {
        Map<MyKey, String> map = new LinkedHashMap<>();

        System.out.println("Добавляем первый элемент...");
        map.put(new MyKey(1), "Один");

        System.out.println("Добавляем второй элемент...");
        map.put(new MyKey(2), "Два");
    }

    static class MyKey {
        int id;
        MyKey(int id) { this.id = id; }

        @Override
        public int hashCode() {
            System.out.println("  -> Java вызвала hashCode() для ключа " + id);
            return id;
        }
    }
}
