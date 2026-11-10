package collectionsframework.map;

//    int size() — возвращает количество пар в Map.
//    boolean isEmpty() — проверяет, пуста ли Map.
//    boolean containsKey(Object key) — есть ли такой ключ.
//    boolean containsValue(Object value) — есть ли такое значение.
//    V get(Object key) — получить значение по ключу (или null, если ключа нет).
//    V put(K key, V value) — добавить пару. Возвращает старое значение, если ключ уже был (и перезаписывает его).
//    V remove(Object key) — удалить пару по ключу. Возвращает удаленное значение.
//    void putAll(Map<? extends K, ? extends V> m) — у
//    void clear() — удалить вообще всё (очистить Map).

//    Set<K> keySet() — возвращает Set всех ключей.
//    Collection<V> values() — возвращает Collection всех значений (значения могут дублироваться).
//    Set<Map.Entry<K, V>> entrySet() — возвращает Set всех пар «ключ-значение» (самый частый способ перебора).

//    V getOrDefault(Object key, V defaultValue) — получить значение, а если ключа нет — вернуть defaultValue.
//    void forEach(BiConsumer action) — пробежаться по всем парам (лямбда-выражение).
//    V putIfAbsent(K key, V value) — добавить пару, только если такого ключа еще нет.
//    boolean remove(Object key, Object value) — удалить пару, только если ключ соответствует значению.
//    V replace(K key, V value) — заменить значение, только если ключ уже существует.
//    boolean replace(K key, V oldValue, V newValue) — заменить, только если ключ имеет конкретное старое значение.
//    void replaceAll(BiFunction function) — заменить все значения по определенному правилу.
//
//    static <K,V> Map<K,V> of(...) — создать неизменяемую Map из 1-10 пар. (Аналог List.of()).
//    static <K,V> Map<K,V> ofEntries(Map.Entry... entries) — создать неизменяемую Map из массива пар.

//    putFirst(K, V) / putLast(K, V) — добавить в начало/конец.
//    firstEntry() / lastEntry() — получить первую/последнюю пару.
//    pollFirstEntry() / pollLastEntry() — забрать первую/последнюю пару и удалить её из Map.
//    reversed() — вернуть перевернутую Map.


import java.util.*;

public class MapDemo {

    static class Item {

        public String number;
        public String name;
        public int age;


        public Item(String number, String name, int age) {
            this.number = number;
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Item item = (Item) o;
//            return (this.number.equals(item.number)) &&
//                    (this.name.equals(item.name)) &&
//                    (this.age == item.age);

            if (this == o) return true;
            if (!(o instanceof Item item)) return false;
            return age == item.age &&
                    Objects.equals(name, item.name) &&
                    Objects.equals(number, item.number);


        }

        @Override
        public int hashCode() {
            return Objects.hash(number, name, age);
        }

        @Override
        public String toString() {
            return "Item{" +
                    "number='" + number + '\'' +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    static void main() {

        Map<Integer, Item> items = new HashMap<>();

        for (int i = 1; i <= 10; i++) {
            String phoneNumber = "+7900000000" + i;
            String name = "Студент_" + i;
            int age = 20 + i;
            int id = 1000 + (i * 2);

            items.put(id, new Item(phoneNumber, name, age));

        }

        System.out.println(" Размер мапы: " + items.size());
        System.out.println(" Мапа Пустая? "  + items.isEmpty());
        System.out.println(" Есть ли такой ключ? " + items.containsKey(1002));
        System.out.println(" Есть ли такое значение? " + items.containsValue(new Item("+79000000001", "Студент_1", 21)));
        System.out.println(" Значнеие по ключу (если нету то null): " + items.get(1002));
        System.out.println();



        // добавили в первый раз (вернул null, мы проигнорировали)
        System.out.println("Старое значение: " + items.put(1002, new Item("+791111111", "Новый студент", 33))); // вывели старое значение
        System.out.println("Теперь в мапе лежит новое: " + items.get(1002));
        System.out.println();
        // А теперь мы хотим узнать, какой возраст был ДО обновления
        Item peopleOld = items.put(1002, new Item("+791111111", "Новый студент", 43)); // А теперь мы хотим узнать, какой возраст был ДО обновления
        System.out.println("В peopleOld передали возраст на момент добавления новго возраст передали старый");
        System.out.println("Узнаём старое значение возраста: " + Objects.requireNonNull(peopleOld).age); // вывели старое значение;
        System.out.println("Теперь там новое значение при сохранении старого: " + items.get(1002));
        System.out.println();



        Item amout1 = new Item("+375339156576", "Студент110902", 21);
        Item amout2 = new Item("+375252345644", "Студент110901", 22);
        items.put(1, amout1);
        System.out.println("До слияния" + items.get(1));
        // тут не то что бы слияние а просто как перезапись ахаахаххаха
        items.merge(1, amout2, (amoutOld, amoutNew) -> {
            // key = значение для слияния;
            // amout2 = объект дополнения;
            // amoutOld = старый объект
            // amoutNew = новый объект;
            amoutOld.age = amoutNew.age;
            amoutOld.number = amoutNew.number;
            amoutOld.name = amoutNew.name;
            return amoutOld;
        });
        System.out.println("После слияния" + items.get(1));
        System.out.println();



        Item amout3 = new Item("+375339156576", "Студент110902", 26);
        items.put(3, amout3);
        Item removedItem = items.remove(3);
        //System.out.print((removedItem != null) ? System.out.printf("Пользователь %s успешно удалён", removedItem.name) : "Удалять пустоту нельзя пустота важна туда что то можно положить");
        if (removedItem != null) {
            System.out.printf("Пользователь %s успешно удалён", removedItem.name);
        } else {
            System.out.println("Удалять пустоту нельзя пустота важна туда что то можно положить");
        }
        System.out.println();




       // void putAll(Map<? extends K, ? extends V> m)
        Map<Integer, Item> students = new HashMap<>();
        Map<Integer, Item> worker = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            students.put(i + 100, new Item("+37533000000" + i, "Студент_№" + i, 17 + i));
        }
        System.out.println();
        System.out.println("Студенты 4 курса");
        for (Integer st : students.keySet()) {
            System.out.println(st + " | " + students.get(st));
        }
        worker.putAll(students); // поверхностное копирование, он не копирует а прекладывает ссылку получаеется 2 мапы ссылаются на один объект в памяти
        System.out.println("Новые работчик");
        for (Integer work : worker.keySet()) {
            System.out.println(work + " | " +worker.get(work));
        }
        System.out.println();



        Map<Integer, Item> apple = new HashMap<>();
        apple.put(1, new Item("dewfwef", "wefwef", 23));
        apple.put(2, new Item("dewfwef", "wefwef", 23));
        apple.put(3, new Item("dewfwef", "wefwef", 23));
        apple.put(4, new Item("dewfwef", "wefwef", 23));
        apple.put(5, new Item("dewfwef", "wefwef", 23));

        System.out.println("Новые яблочки перед очищением");
        for (Integer app : apple.keySet()) {
            System.out.println(apple.get(app));
        }
        System.out.println((apple.isEmpty()) ? "список полон яблочками" : "не делай этого парень");
        apple.clear();
        System.out.println("Как ты мог так поступить? Яблочки.... ");
        System.out.println();




        Map<Integer, String> user = new HashMap<>();
        for (int i = 1; i <= 10; i ++) {
            user.put(i, "Пользователь " + i);
        }
        // Переберать ключи
        Set<Integer> key = user.keySet();
        System.out.println(key);
        for (Integer set : user.keySet()) {
            System.out.print(set + ", ");
        }
        System.out.println();

        // Перебрать значения
        Collection<String> value = user.values();
        System.out.println(value);
        for (String val : user.values()) {
            System.out.print(val + ", ");
        }
        System.out.println();

        // MapEntry - самй чисты способ вывода
        Set<Map.Entry<Integer, String>> entry = user.entrySet();
        System.out.println(entry);
        for (Map.Entry<Integer, String> en : user.entrySet()) {
            System.out.println(en.getKey() + " | " + en.getValue());
        }
        System.out.println();



        Map<Integer, String> getOrDefaultDemo = new HashMap<>();
        getOrDefaultDemo.put(1, "qweqwe");
        getOrDefaultDemo.put(2, "qweqwe");
        getOrDefaultDemo.put(3, "qweqwe");
        getOrDefaultDemo.put(4, "qweqwe");
        getOrDefaultDemo.put(5, null);

        // Если getOrDefault - проверяет есть ли ключ в мапе ? получает значение : отдаёт дефолтное значение
        // То putIfAbsent - если ключа нет ? создаст : если значение не равно null ничего не сделает, а если равно подставит

        String count = getOrDefaultDemo.getOrDefault(5, "нету");
        System.out.println(count);
        getOrDefaultDemo.putIfAbsent(6, "4343");
        String count2 = getOrDefaultDemo.getOrDefault(6, "нету");
        System.out.println(count2);
        getOrDefaultDemo.putIfAbsent(6, "11111111");
        String count3 = getOrDefaultDemo.getOrDefault(6, "нету");
        System.out.print(count3);

        Map<String, Integer> test = new HashMap<>();
        test.put("Пользователь1", 123);
        test.put("Пользователь2", 3213);
        test.put("Пользователь3", 555);
        test.put("Пользователь4", 1767);
        test.put("Пользователь5", null);

        //Objects.requireNonNull() - если значение не null ? пропускаю : падаю с ошибкой
        //Objects.requireNonNullElse() - если значение не null ? пропускаю : подставляет дефолт значение

        System.out.println();
        Integer count0 = test.getOrDefault("Пользователь5", 5);
        Integer count01 = Objects.requireNonNullElse(test.getOrDefault("Пользователь5", 5), 0);
        if(count01 < 100) {
            // Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Integer.intValue()" because "count0" is null
            //	at map.MapDemo.main(MapDemo.java:238)
            // Как исправить ?

            //      if (count0 != null && count0 >= 100) {
            //            System.out.println("Djn greyware");
            //      }
            System.out.println("Djn greyware");
        }

        System.out.println();
        Map<Integer, String> order = new HashMap<>();
        order.put(1, "Новый");
        order.put(2, "Оплачен");
        order.put(3, "Оплачен");
        order.put(4, "Новый");
        order.put(5, null);

        boolean isDelete = order.remove(1, "Новый");
        if (isDelete) {
            System.out.println("Удалён");
        } else {
            System.out.println("Заказ оплачен");
        }

        boolean isDelete2 = order.remove(2, "Новый");
        if (isDelete2) {
            System.out.println("Удалён");
        } else {
            System.out.println("Заказ оплачен");
        }

        boolean success = order.replace(4, "Новый", "Оплачен");

        if (success) {
            System.out.println("Статус успешно обновлен!");
        } else {
            System.out.println("Кто-то уже изменил статус, пока мы думали.");
        }


        System.out.println();
        Map<String, Integer> replaceDemo = new HashMap<>();
        replaceDemo.put("Вася", 34);
        replaceDemo.put("Саша", 54);
        replaceDemo.put("юра", 65);
        replaceDemo.put("Игорь", 12);
        replaceDemo.put("Тамара", null);

        Integer oldAge = replaceDemo.replace("Вася", 76);
        System.out.println(oldAge);
        System.out.println(replaceDemo.get("Вася"));


        System.out.println();
        Map<String, Integer> prices = new HashMap<>();
        prices.put("Яблоко", 100);
        prices.put("Банан", 200);

        System.out.println("До замены:");
        for (String key1 : prices.keySet()) {
            System.out.println(prices.get(key1));
        }

        for (String key1 : prices.keySet()) {
            Integer oldValue = prices.get(key1);
            int newValue = (int)(oldValue * 0.9);
            prices.put(key1, newValue);
        }

        System.out.println("Замена обычным способом:");
        for (String key1 : prices.keySet()) {
            System.out.println(prices.get(key1));
        }

        prices.replaceAll((key1, value1) -> (int)(value1 * 2));
        System.out.println("Замена с помощью replaceAll + лямбда:");
        for (String key1 : prices.keySet()) {
            System.out.println(prices.get(key1));
        }


        System.out.println();
        System.out.println("Неизменяемая мапа до 10 пар: ");
        Map<String, Integer> ages = Map.of(
                "Вася", 25,
                "Петя", 30,
                "Маша", 22
        );

//        Максимум 10 пар. Если нужно 11 — этот метод не сработает (нужно использовать ofEntries).
//        Нельзя null. Ни ключ, ни значение не могут быть null. Если попытаешься — упадет с NullPointerException.
//        Дубликаты нельзя. Если напишешь "Вася", 25, "Вася", 26, программа упадет. (Потому что ключи должны быть уникальны, а бетон не позволяет перезаписать).

        for (String key1 : ages.keySet()) {
            System.out.println(ages.get(key1));
        }

        System.out.println();
        System.out.println("Неизменяемая мапа больше 10: ");
        Map<String, Integer> bigMap = Map.ofEntries(
                Map.entry("Ключ1", 100),
                Map.entry("Ключ2", 200),
                Map.entry("Ключ3", 300),
                Map.entry("Ключ4", 400),
                Map.entry("Ключ5", 500)
        );

        for (String key1 : bigMap.keySet()) {
            System.out.println(bigMap.get(key1));
        }

        // public HashMap(int initialCapacity, float loadFactor)
        Map<String, String> map = new HashMap<>(16, 0.6f);
        for (int i = 1; i <= 15; i++) {
            map.put("Ключ" + i, "Значение" + i);
            System.out.println("Добавили " + i + " элементов. Размер: " + map.size());
        }

    }

}
