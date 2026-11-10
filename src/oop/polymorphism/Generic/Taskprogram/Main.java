package oop.polymorphism.Generic.Taskprogram;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //создаём двухуровневую хеш-таблицу для хранения расписания уроков
        AdvancedHashMap<String, Integer, String> timetable = new AdvancedHashMap<>();
        //добавляем уроки, с указанием дня недели и номера урока
        timetable.put("Понедельник", 1, "Русский язык");
        timetable.put("Понедельник", 2, "Математика");
        timetable.put("Вторник", 1, "Физкультура");
        timetable.put("Вторник", 2, "Русский язык");

        //выводим первый урок во вторник
        System.out.println(timetable.get("Вторник", 1));

        //получаем и выводим все уроки в понедельник
        ArrayList<String> mondayLessons = timetable.getAll("Понедельник");
        System.out.println(mondayLessons);
    }

}

class AdvancedHashMap<K, T, V> {
        //данные будем хранить в хеш-таблице из хеш-таблиц
        HashMap<K, HashMap<T, V>> internalHashMap = new HashMap<>();

        public void put(K key1, T key2, V value1) {
            //получаем хеш-таблицу по первому ключу
            HashMap<T, V> innerHashMap = internalHashMap.get(key1);
            if (innerHashMap == null) {
                //вложенной хеш-таблицы по первому ключу пока нет — создаём её и добавляем в internalHashMap
                innerHashMap = new HashMap<>();
                internalHashMap.put(key1, innerHashMap);
            }
            //добавляем элемент во вложенную хеш-таблицу
            innerHashMap.put(key2, value1);
        }

        public V get(K key1, T key2) {
            //получаем хеш-таблицу по первому ключу
            HashMap<T, V> innerHashMap = internalHashMap.get(key1);
            if (innerHashMap == null) {
                return null;
            }
            //получаем элемент из вложенной хеш-таблицы
            return innerHashMap.get(key2);
        }

        public ArrayList<V> getAll(K key1) {
            HashMap<T, V> innerHashMap = internalHashMap.get(key1);
            if (innerHashMap == null) {
                return new ArrayList<>();
            }
            return new ArrayList<>(innerHashMap.values());
            // Так как метод по контракту обязан вернуть именно ArrayList, мы создаем новый пустой список и прямо в его
            // конструктор передаем пачку значений, которую вытащили шагом ранее. Java автоматически берет эту коллекцию
            // и перекладывает элементы в новенький ArrayList.
        }
}