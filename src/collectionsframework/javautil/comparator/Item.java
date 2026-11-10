package collectionsframework.javautil.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Item implements Comparable<Item> {

    static void main() {

        List<Item> items = new ArrayList<>();
        items.add(new Item("Рубашка", 4500, 37));
        items.add(new Item("Носки", 55, 8));
        items.add(new Item("Толстовка", 1399, 74));
        items.add(new Item("Носки", 169, 19));

        ItemPriceComparator itemPriceComparator = new ItemPriceComparator();
        Comparator<Item> itemPriceComparatorReversed = itemPriceComparator.reversed();
        ItemStringInsensitiveNameComparator stringInsensitiveNameComparator = new ItemStringInsensitiveNameComparator();
        ItemPopularityComparator iItemPopularityComparator = new ItemPopularityComparator();
        ItemSNameComparator itemSNameComparator = new ItemSNameComparator();

        items.sort(new ItemPriceComparator());
        System.out.println(items); // под копотом -> перемещаем в массив -> сортируем через статику -> итератор -> обратно в список

        items.sort(itemPriceComparatorReversed);
        System.out.println("\n" + items);

        items.sort(stringInsensitiveNameComparator);
        System.out.println("\n" + items);


        List<Item> itemsNew = new ArrayList<>();
        itemsNew.add(new Item("Рубашка", 4500, 37));
        itemsNew.add(new Item("Рубашка", 55, 8));
        itemsNew.add(new Item("Толстовка", 1399, 74));
        itemsNew.add(new Item("Толстовка", 1399, 19));
        itemsNew.add(new Item("Носки", 19, 19));

        Comparator<Item> treeComparator = itemSNameComparator.thenComparing(itemPriceComparator).thenComparing(iItemPopularityComparator);
        itemsNew.sort(treeComparator);
        System.out.println("\n" + itemsNew);

//        items.add(new Item("Носки", 19, 19));
//        items.add(new Item("Рубашка", 55, 8));
//        items.add(new Item("Рубашка", 4500, 37));
//        items.add(new Item("Толстовка", 1399, 19));
//        items.add(new Item("Толстовка", 1399, 74));

    }

    static class ItemPriceComparator implements Comparator<Item> { // по цене

        @Override
        public int compare(Item item1, Item item2) {

            // сравниваем товары — более дорогой должен быть дальше в списке
            // более дешёвый — ближе к началу списка
            // если стоимость равна, нужно вернуть 0
            return Integer.compare(item1.price, item2.price);  // статические методы сравнения

            /*
            более дорогой должен быть дальше в списке
            if (item1.price > item2.price) {
                return 1;

            более дешёвый — ближе к началу списка
            } else if (item1.price < item2.price) {
                return -1;

             если стоимость равна, нужно вернуть 0
            } else {
                return 0;
            }
            */
        }
    }


    static class ItemPopularityComparator implements Comparator<Item> { // по цене

        @Override
        public int compare(Item item1, Item item2) {

            return Integer.compare(item1.popularity, item2.popularity);

        }
    }

    static class ItemStringInsensitiveNameComparator implements Comparator<Item> {

        /*
         String.CASE_INSENSITIVE_ORDER принимает строки в качестве аргументов,
         поэтому передадим названия товаров в его метод .compare(...)
         */
        @Override
        public int compare(Item item1, Item item2) {
            return String.CASE_INSENSITIVE_ORDER.compare(item1.name, item2.name);
        }
    }

    static class ItemSNameComparator implements Comparator<Item> {

        /*
         String.CASE_INSENSITIVE_ORDER принимает строки в качестве аргументов,
         поэтому передадим названия товаров в его метод .compare(...)
         */
        @Override
        public int compare(Item item1, Item item2) {
            return item1.name.compareTo(item2.name);
        }
    }



    public final String name; // название товара
    public final int price; // цена
    public final int popularity; // популярность

    public Item(String name, int price, int popularity) {
        this.name = name;
        this.price = price;
        this.popularity = popularity;
    }

    @Override
    public int compareTo(Item item){
        return this.name.compareTo(item.name);
    }

    // сразу переопределим toString(), чтобы потом выводить содержание списка
    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", popularity=" + popularity +
                '}';
    }

}


