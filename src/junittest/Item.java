package junittest;

import java.util.Objects;

public class Item {

    private String name;
    private int price;
    private static int count;

    public Item(String name, int price){
        this.name = name;
        this.price = price;
        count++;
    }

    public int getCount(){
        return count;
    }

    @Override
    public String toString(){
        return String.format("Наменклатура: %s, Цена: %s ban, id: %s ", name, price, getCount());
        //return name + ", Цена: " + price + " ban, Товар id: " + getCount();
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return price == item.price && Objects.equals(name, item.name);
    }

}
