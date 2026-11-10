package collectionsframework.map;

import java.util.*;

import static java.lang.IO.print;
import static java.lang.IO.println;

public final class TreeMapDemo {

    static void main() {


        TreeMap<Integer, String> tree = new TreeMap<>();
        tree.put(13, "тринадцать");
        tree.put(1, "один");
        tree.put(97, "девяноста семь");
        tree.put(34, "тридцать четыре");
        tree.put(17, "семнадцать");

        println("Наименьший элемент: " + tree.firstEntry()); // наименьшее
        println("Первый ключ : "  + tree.firstKey());  // первый ключ
        println("Наибольший элемент: " + tree.lastEntry()); // наибольшее
        println("Последний ключ: " + tree.lastKey());  // последний ключ

        println(tree);
        println("Вывели первую пару и удалили с мапы: " + tree.pollFirstEntry()); // выводит и удаляет первую пару
        println("Вывели последнюю пару и удалили с мапы: " + tree.pollLastEntry()); // выводит и удаляет последнюю пару
        println(tree);

        println("----------------------------------------------------------------------------------------------------");
        println();
        System.out.println("Использования List вместо 3 конструктора");
        Map<Item, Integer> hashMap = new HashMap<>();
        hashMap.put(new Item("Женя", 24), 2001);
        hashMap.put(new Item("Кристина", 17), 2009);
        hashMap.put(new Item("Виолетта", 14), 2012);
        hashMap.put(new Item("Кристина", 9), 2017);
        hashMap.put(new Item("Кристина", 19), 2007);

        List<Map.Entry<Item, Integer>> list = new ArrayList<>(hashMap.entrySet());

        list.sort(Map.Entry.comparingByKey()); // вернёт компаратор который сам сравнит по ключам, но только если реализован у ключа объекта интерфейс Comparable
        System.out.println("По ключам: ");
        for (Map.Entry<Item, Integer> last : list) {
            System.out.println(last);
        }
        list.sort(Map.Entry.comparingByValue());
        System.out.println("По значению: ");
        for (Map.Entry<Item, Integer> last : list) {
            System.out.println(last);
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Первый конструктор: ");
        Map<Item, Integer> map = new TreeMap<>();
        map.put(new Item("Женя", 24), 2001);
        map.put(new Item("Кристина", 17), 2009);
        map.put(new Item("Виолетта", 14), 2012);
        map.put(new Item("Кристина", 9), 2017);
        map.put(new Item("Кристина", 19), 2007);

        for(Map.Entry<Item, Integer> mapy : map.entrySet()){
            System.out.println(mapy.getKey() + " | " + mapy.getValue());
        }

        Comparator<Item> comparator = new SortItemName().thenComparing(new SortItemAge());
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Второй конструктор: ");
        Map<Item, Integer> map2 = new TreeMap<>(comparator);
        map2.put(new Item("Женя", 24), 2001);
        map2.put(new Item("Кристина", 17), 2009);
        map2.put(new Item("Виолетта", 14), 2012);
        map2.put(new Item("Кристина", 9), 2017);
        map2.put(new Item("Кристина", 19), 2007);

        for(Map.Entry<Item, Integer> mapy : map2.entrySet()){
            System.out.println(mapy.getKey() + " | " + mapy.getValue());
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Третий конструктор: "); // Обязаны реализовывать метод compareTo Comparable? Comparator передать нельзя
        System.out.println("Хаос мапа - ключ Integer: ");
        Map<Integer, Item> map3 = new HashMap<>();
        map3.put(2010, new Item("Женя", 24));
        map3.put(2001, new Item("Кристина", 17));
        map3.put(2005 ,new Item("Виолетта", 14));
        map3.put(2027, new Item("Кристина", 9));
        map3.put(2018, new Item("Кристина", 19));

        System.out.println(map3);
        System.out.println("Отсортированная мапа c Integer: ");
        Map<Integer, Item> map4 = new TreeMap<>(map3);
        for(Map.Entry<Integer, Item> mapy : map4.entrySet()){
            System.out.println(mapy.getKey() + " | " + mapy.getValue());
        }

        System.out.println("Хаос мапа - ключ String: ");
        Map<String, Item> map5 = new HashMap<>();
        map5.put("Белый", new Item("Женя", 24));
        map5.put("Красный", new Item("Кристина", 17));
        map5.put("Чёрный" ,new Item("Виолетта", 14));
        map5.put("Оливковый", new Item("Кристина", 9));
        map5.put("Медный", new Item("Кристина", 19));

        System.out.println(map5);
        System.out.println("Отсортированная мапа c String: ");
        Map<String, Item> map6 = new TreeMap<>(map5);
        for(Map.Entry<String, Item> mapy : map6.entrySet()){
            System.out.println(mapy.getKey() + " | " + mapy.getValue());
        }

        System.out.println("Хаос мапа - ключ Item без Comparable: ");
        System.out.println("ошибка из за отсутвие в ключе имплементации интерфейса Comparable");
        Map<ItemNoComparable, Integer> map7 = new HashMap<>();
        map7.put(new ItemNoComparable("Женя", 24), 2001);
        map7.put(new ItemNoComparable("Кристина", 17), 2009);
        map7.put(new ItemNoComparable("Виолетта", 14), 2012);
        map7.put(new ItemNoComparable("Кристина", 9), 2017);
        map7.put(new ItemNoComparable("Кристина", 19), 2007);

        // CAST EXCEPTION
//        System.out.println(map7);
//        System.out.println("Отсортированная мапа c Item без Comparable: ");
//        Map<ItemNoComparable, Integer> map8 = new TreeMap<>(map7);
//        for(Map.Entry<ItemNoComparable, Integer> mapy : map8.entrySet()){
//            System.out.println(mapy.getKey() + " | " + mapy.getValue());
//        }

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Четвёртый конструктор: ");
        TreeMap<ItemNoComparable, Integer> map9 = new TreeMap<>(new ItemNoComparableAddComparator());
        map9.put(new ItemNoComparable("Женя", 24), 2001);
        map9.put(new ItemNoComparable("Кристина", 17), 2009);
        map9.put(new ItemNoComparable("Виолетта", 14), 2012);
        map9.put(new ItemNoComparable("Кристина", 9), 2017);
        map9.put(new ItemNoComparable("Кристина", 19), 2007);

        for(Map.Entry<ItemNoComparable, Integer> mapy : map9.entrySet()){
            System.out.println(mapy.getKey() + " | " + mapy.getValue());
        }
        System.out.println();
        TreeMap<ItemNoComparable, Integer> map10 = new TreeMap<>(map9);
        for(Map.Entry<ItemNoComparable, Integer> mapy : map10.entrySet()){
            System.out.println(mapy.getKey() + " | " + mapy.getValue());
        }

    }

    static final class Item implements Comparable<Item> {
        private final String name;
        private final int age;

        public Item(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || this.getClass() != obj.getClass()) return false;
            Item item = (Item) obj;
            return Objects.equals(this.name, item.name) &&
                    age == item.age;
            //if(!(obj instanceof Item item)) return false;

        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public int compareTo(Item item) {
            int value = String.CASE_INSENSITIVE_ORDER.compare(this.name, item.name);
            if (value != 0) {
                return value;
            } else {
                return Integer.compare(this.age, item.age);
            }
        }

        @Override
        public String toString() {
            return "[" + name + ", " + age + "] ";
        }
    }

    static final class SortItemName implements Comparator<Item> {
        // @Contract(pure = true) - он ничего не меняет в объектах, а просто читает данные и возвращает результат (сравнивает имена).
        @Override
        public int compare(Item item, Item item1){
            return String.CASE_INSENSITIVE_ORDER.compare(item.name, item1.name);
        }
    }

    static final class SortItemAge implements Comparator<Item> {
        // @Contract(pure = true) - он ничего не меняет в объектах, а просто читает данные и возвращает результат (сравнивает имена).
        @Override
        public int compare(Item item, Item item1){
            return Integer.compare(item.age, item1.age);
        }
    }

    static final class ItemNoComparable { // Для показа ошибки при касте внутри
        private final String name;
        private final int age;

        public ItemNoComparable(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || this.getClass() != obj.getClass()) return false;
            ItemNoComparable item = (ItemNoComparable) obj;
            return Objects.equals(this.name, item.name) &&
                    age == item.age;
            //if(!(obj instanceof ItemNoComparable)) return false;

        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return "[" + name + ", " + age + "] ";
        }
    }

    static final class ItemNoComparableAddComparator implements Comparator<ItemNoComparable>{
        @Override
        public int compare(ItemNoComparable i1, ItemNoComparable i2) {
            return String.CASE_INSENSITIVE_ORDER.compare(i1.name, i2.name);
        }
    }


}

