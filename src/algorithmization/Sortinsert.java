package algorithmization;

import java.util.Arrays;

import static java.lang.IO.print;

public class Sortinsert {

    void main() {
        int[] array = {67, 5, 6, 7, 98, 2, 45, 123, 987, 1, 0};
        print(Arrays.toString(array));
        insertionSort(array);
        IO.println(Arrays.toString(array));
    }

     static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {   // элемент [0] уже отсортирован;
            int key = array[i];         // запоминаем текущий элемент;
            int j = i - 1;              // проверяем элементы слева от него;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;    // -1
            }

            array[j + 1] = key;
        }
    }

}
