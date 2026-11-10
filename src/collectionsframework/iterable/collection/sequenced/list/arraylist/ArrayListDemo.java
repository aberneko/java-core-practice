package collectionsframework.iterable.collection.sequenced.list.arraylist;
//import java.util.AbstractList;
//import java.util.AbstractCollection;
import java.util.ArrayList;

public class ArrayListDemo {

    // iterable(и) -> Collection(И) -> List(И)
    //                                                                              -->> ArrayList(К)
    //                                                        -->> AbstractList(AK)
    //                              -> AbstractCollection(АК) 
    //                              (Поиск и удаление элементов)

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        // elementData - основа, самый обычный массив
        // если размер == 0 : create EMPTY_ELEMENTDATA, и все пустые списки ссылаются на него .. эконом
        // если размера нет, и видно что по конструктору == DEFAULTCAPACITY_EMPTY_ELEMENTDATA создаст размер на 10 ячеек
        // Оба массива изначально занимают 0 байт
        
        int initialCapacity = 20;
        ArrayList<String> listCapacity = new ArrayList<>(initialCapacity);
        // По умолчанию Вместимость 10 элементов 
        // Увеличение вместимости +50% - в меньшую сторону округление
        // Фактический размер 0

        list.add("0"); // сложность O(1) : незаполненный список (в лучшем)
            list.add("n + 50%"); // сложность O(n) : увеличение массива (в худшем)
            // амортизированной асимптотической сложности
            list.add("n + 50%"); // сложновть 0(1) : умножение на 1.5 (в среднем)
            //                                         int newCapacity = oldCapacity + (oldCapacity >> 1);
            //                                                                         это сдвиг бит вправо на 1, что эквивалентно делению на 2
        list.add(1, "<T>"); // сложноть О(n) : чем дальше от правого конца, тем больше сдвигов + если ёмкость заполнена  : расширение O(n)
            list.remove(1); list.remove("<T>"); // сложноть О(n) : тоже зависит от количества элементов
        
        list.get(0); list.set(0, "1"); // сложность О(1); 



        


    }

}
