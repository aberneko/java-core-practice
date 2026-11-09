package algorithmization;

import java.util.Arrays;

public class BinarySearch {
    static void main() {

        int[] arrayInteger = new int[]{1, 3, 4, 5, 6, 7, 8, 9};
        int index = -1;
        int number = 9;
        int low = 0; // индекс первого элемента массива
        int last = arrayInteger.length - 1; // индекс последнего элемента массива

        while (low <= last) {
            int mid = low + ((last - low) / 2 );
            if (arrayInteger[mid] < number) { // смещаем границы правее
                low = mid + 1;
            } else if (arrayInteger[mid] == number) { // смещаем границы левее
                index = mid;
                break;
            } else {
                last = mid - 1;
            }
        }

        System.out.print("Индекс искомого элемента: " + index);


        // или вызываем из библиотеки
        int[] arrayInteger2 = new int[]{1, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("\nИндекс искомого элемента: " + Arrays.binarySearch(arrayInteger2, 5));
    }
}
