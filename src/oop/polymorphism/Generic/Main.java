package oop.polymorphism.Generic;

import java.util.ArrayList;

public class Main {
    static void main() {
        ArrayList<String> prisonerLines = new ArrayList<>();
        prisonerLines.add("Сижу за решеткой в темнице сырой.");
        prisonerLines.add("Вскормленный в неволе орел молодой,");
        prisonerLines.add("Мой грустный товарищ, махая крылом,");
        prisonerLines.add("Кровавую пищу клюет под окном,");

        printPoem(prisonerLines);

        ArrayList<Item> person = new ArrayList<>();
        person.add(new Item("Кристина", "Веренич"));
        person.add(new Item("Евгений", "Самусенко"));

        printSmart(person);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Красный", "Буйвол"));
        animals.add(new Animal("Зелёный", "Кузнечик"));

        printSmart(animals);
        System.out.println("---------------------------------------");

        String name = null;
        String nameOrDefault = ifNull(name, "привет");
        System.out.println(nameOrDefault);

        Integer numberOrDefault = ifNull(1, 1);
        System.out.println(numberOrDefault);

        System.out.println("---------------------------------------");

        ArrayList<String> words = new ArrayList<>();
        words.add("alpha");
        words.add("beta");
        words.add("gamma");
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(200);
        numbers.add(300);

        String firstWord = getFirstElement(words);
        Integer firstNumber = getFirstElement(numbers);

        System.out.println("Первое слово: " + firstWord);
        System.out.println("Первое число: " + firstNumber);

        System.out.println("---------------------------------------");

        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("яблоко");
        fruits.add("груша");
        fruits.add("яблоко");
        fruits.add("слива");
        fruits.add("яблоко");
        fruits.add("яблоко");
        fruits.add("яблоко");

        int count = countMatches(fruits, "яблоко");
        System.out.println("Количество яблок: " + count);

        System.out.println("---------------------------------------");

        Box<String> boxString = new Box<>("Евгений", "Самусенко");
        Box<Integer> boxInteger = new Box<>(1, 1);

        System.out.printf("(%s, %s)", boxString, boxInteger);

        System.out.println("\n---------------------------------------");

        BoxMap<String, Integer> itemOne = new BoxMap<>("Кристина", 12345678); // это просто объект
        BoxMap<String, Integer> itemTwo = new BoxMap<>("Женя", 456456456); // и это просто объект
        BoxMap<String, Integer> itemThree = new BoxMap<>("Кирилл", 786867867); // и это просто объект
        BoxMap<String, Integer> itemFour = new BoxMap<>("Саша", 43243423); // а вто ещё просто объект

        ArrayList<BoxMap<String, Integer>> arrayList = new ArrayList<>();
        arrayList.add(itemOne);
        arrayList.add(itemTwo);
        arrayList.add(itemThree);
        arrayList.add(itemFour);

        String keyFound = "Кристина"; // ищем номер Кристины
        Integer getNumber = null;

        for(BoxMap<String, Integer> mapi : arrayList){
            if(mapi.getKey().equals(keyFound)){
                getNumber = mapi.getValue();
                break;                                  // как нашли останавливаем поиск
            }
        }

        System.out.printf("Найденный номер по запросу: %s", getNumber);
    }

    static void printPoem(ArrayList<String> poemLines) {
        System.out.println("\t\t\t\t\t ***");
        for (String line : poemLines) {
            System.out.println("\t " + line);
        }
    }

    // <T> — указали, что метод будет использовать параметр типа с именем T
    // ArrayList<T> items — использовали ранее объявленный параметр типа — T, чтобы
    // указать, что передаваемый в метод список может содержать элементы
    // любого типа, который будет подставлен вместо T во время вызова метода
    static <T> void printSmart(ArrayList<T> person) {
        System.out.println("\t\t\t\t\t ***");
        for (T pers : person) {
            System.out.println("\t " + pers);
        }
    }

    // Так было раньше
    static void printSmart1(ArrayList person) {
        for (int i = 0; i < person.size(); i++) {
            String string = (String) person.get(i);
            System.out.println(string);
        }
    }

    public static <T> T ifNull(T value, T defaultValue) {
        return value == null ? defaultValue : value;
    }

    public static <T> T getFirstElement(ArrayList<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static <T> int countMatches(ArrayList<T> arrayList, T value){
        int count = 0;
        for(T array : arrayList){
            if(array.equals(value)){
                count++;
            }
        }
        return count;
    }
}

class Item {

    String name;
    String surname;

    public Item(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

}

class Animal {

    String name;
    String surname;

    public Animal(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

}

class Box<T>{
    private T value;
    private T value2;

    public Box(T value, T value2) {
        this.value = value;
        this.value2 = value2;
    }

    public T getValue() {
        return value;
    }

    public T getValue2() {
        return value2;
    }

    @Override
    public String toString() {
        return value + " " + value2;
    }
}

class BoxMap<K, V>{
    private final K key;
    private V value;

    public BoxMap(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setvalue(V valueNew){
        this.value = valueNew;
    }

    @Override
    public String toString() {
        return key + " " + value;
    }
}



