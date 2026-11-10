package collectionsframework.iterable.collection;

import java.util.*;

import static java.lang.IO.println;

public class CollectionDemo { // интерфейс Collection<T>

    // addAll(Collection c)
    // removeAll(Collection c)
    // containsAll(Collection c)

    final static Collection<String> colors = new ArrayList<>(); // прейти в пособие

    static void main() {
        colors.add("Жёлтый");
        colors.add("Зелёный");
        println("// addAll(Collection c)");
        println("   " + colors);

        colors.addAll(List.of("Оранжевый", "Серый"));
        colors.addAll(List.of("Фиолетовый", "Сиреневый"));
        println("   " + colors);

        colors.removeAll(List.of("Оранжевый", "Серый"));
        println("// removeAll(Collection c)");
        println("   " + colors);

        Collection<String> collection = List.of("Жёлтый", "Зелёный");
        println("// containsAll(Collection c)");
        println("   Список содержит Жёлтый и Зелённый : " + isTrueFalse(collection));


        // Класс-помощник (утилитарный класс) Collection(s)

        // Collections.emptyList()
        // Collections.singletonList(T element)
        // Collections.nCopies(int n, T element)

        // НЕизменяемые списки
        final List<String> emptyList = Collections.emptyList();
        final List<String> singletonList = Collections.singletonList("Привет");
        final List<String> nCopiesList = Collections.nCopies(5, "Java");

        System.out.println(emptyList); // возвращает пустой список;
        System.out.println(singletonList); //  возвращает список из одного элемента element;
        System.out.println(nCopiesList); // возвращает список из n элементов, каждый из которых является ссылкой на один и тот же объект element.

        // меняем неизменяемость
        final List<String> immutableList = List.of("Ёж", "Медведь", "Лиса");
        final ArrayList<String> mutableList = new ArrayList<>(immutableList);
        mutableList.add("Заяц");
        System.out.println(mutableList);
        // immutableList.add("Заяц"); at java.base/java.util.ImmutableCollections$AbstractImmutableCollection.add(ImmutableCollections.java:150)


        // Collections.fill(List<T>, T)
        List<Long> listOfLongs = new ArrayList<>();
        listOfLongs.add(157478403L);
        listOfLongs.add(2450033L);
        listOfLongs.add(32039458858604L);
        System.out.println("\n" + listOfLongs);
        Collections.fill(listOfLongs, 12L); // присвоить всем элементам списка List<T> единое значение T
        System.out.println(listOfLongs);


        // Collections.copy(List<T>, List<T>)
        List<String> nameGroupeA = List.of("Женя", "Кристина", "Курапика");
        List<String> nameGroupeB = List.of("Кирилл", "Курапико", "Евангелион");
        // Collections.copy(nameGroupeA, nameGroupeB); // Нельяз так как неизменяемый

        List<String> nameGroupeAmutable = new ArrayList<>(nameGroupeA);
        List<String> nameGroupeBmutable = new ArrayList<>(nameGroupeB);
        System.out.println(nameGroupeAmutable);
        System.out.println(nameGroupeBmutable);
        Collections.copy(nameGroupeAmutable, nameGroupeBmutable);
        System.out.println(nameGroupeAmutable);
        System.out.println(nameGroupeBmutable);

        // Collections.sort(List<T>, Comparator<T>)
        List<String> fruits = new ArrayList<>();
        fruits.add("Банан");
        fruits.add("Апельсин");
        fruits.add("Яблоко");
        fruits.add("Груша");

        System.out.println("\n" + fruits);
        Collections.sort(fruits, String.CASE_INSENSITIVE_ORDER);
        System.out.println(fruits);
        List<String> reversedList = fruits.reversed();
        reversedList.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println("\n" + fruits);


        // Collections.min(Collection<? extends T> coll)
        // Collections.max(Collection<? extends T> coll>)
        final Item a = new Item("aaa", 30);
        final Item b = new Item("aaa", 27);
        final Item c = new Item("ccc", 33);
        final Item d = new Item("ddd", 21);

        // создаём изменяемый список из неизменяемого List.of(..)
        final List<Item> list = new ArrayList<>(List.of(a, b, c, d));
        Collections.sort(list);
        System.out.println("\n" + list);

        // выводим минимальный элемент в соответствии с правилами сортировки Comparable<Student>
        // так как список предварительно отсортирован, минимальным будет первый элемент
        System.out.println(Collections.min(list));

        // теперь напечатаем максимальный элемент
        System.out.println(Collections.max(list));

//        public static <T extends Object & Comparable<? super T>> T min(Collection<? extends T> coll) { // проверка на принадлежность главному классу + проверка на реализацию сортировки самим классом + защита передачи классов наследников они не реализуют интерфейс поэтому повышаются до родителя
//            Iterator<? extends T> i = coll.iterator(); //  так как коспилятор повысил наш класс наследник до родителя он пропускает нашего наследника но итератер без extends равнялся бы просто классу родитель и тогда возник бы ступор так ка мы пытаемся наш класс наследник записать в список родителя а так нельзя поэтому и нужен extends                                              // защита от
//            T candidate = i.next(); // возвращаем первый элемент  и передвегаем указатель
//
//            while (i.hasNext()) { // проверяем есть ли дальше что нибуть если есть то создаём новый указатель
//                T next = i.next(); // Достаем следующий элемент и сдвигаем указатель еще дальше.
//                if (next.compareTo(candidate) < 0)  // Если метод вернул число меньше 0, значит текущий элемент (next) МЕНЬШЕ нашего кандидата.
//                    candidate = next; // Забываем старого кандидата и записываем на его место этот next.
//            }
//            return candidate; // возврашаем наш минимальный элемент
//        }


        // Collections.min(Collection<T>, Comparator<T>)
        // Collections.max(Collection<T>, Comparator<T>)

        System.out.println("\n" + Collections.min(list, new ItemComparator()));

        // теперь напечатаем максимальный элемент
        System.out.println(Collections.max(list, Item::compareTo));

    }

    static class ItemComparator implements Comparator<Item> {
        @Override
        public int compare(Item item1, Item item2) {

            return Integer.compare(item1.age, item2.age);

        }
    }

    static class Item implements Comparable<Item> {
        final private String name;
        final private int age;

        public Item(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName(){
            return name;
        }

        public int getAge(){
            return age;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }

        @Override
        public int compareTo(Item item) {
            final int valueName = String.CASE_INSENSITIVE_ORDER.compare(this.name, item.name);
            if (valueName != 0) {
                return valueName;
            } else {
                return Integer.compare(this.age, item.age);
            }
        }
    }

    public static String isTrueFalse(Collection<String> collection) {
        return colors.containsAll(collection) ? "Правда" : "Ложь";
    }



}


