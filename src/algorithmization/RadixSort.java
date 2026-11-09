package algorithmization;

public class RadixSort {
    static void main() {

    }

    public static void radixSort(int[] array) {
        if (array.length == 0) return;
        // 1. находим максимальное число, чтобы узнать количество разрядов
        int max = getMax(array);

        // 2. Проходим по всем разрядам: exp = 1 (единицы), 10 (десятки), 100 (сотни)...
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSortByDigit(array, exp);
        }
    }
    // Вспомогательная устойчивая сортировка подсчетом по конкретному разряду
    private static void countSortByDigit(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n]; // временный массив для результата
        int[] count = new int[10]; // так как цифры от 0 до 9

        // Подсчитываем количество совпадений текущей цифры
        for (int i = 0; i < n; i++) {
            int digit = (array[i] / exp) % 10;
            count[digit]++;
        }

    }

    private static int getMax(int[] array){
        int max = array[0];
        for (int arr : array) {
            if (array[arr] > max) max = array[arr];
        }
        return max;
    }
}
