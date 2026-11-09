package arrays;

import java.util.Arrays;

public class ArraysUtilityDemo {
    public static void main(String[] args) {
        int[] numbers = {45, 12, 78, 3, 22};

        System.out.println("Исходный массив: " + Arrays.toString(numbers));

        // Сортировка массива
        Arrays.sort(numbers);
        System.out.println("Отсортированный массив: " + Arrays.toString(numbers));

        // копирование и расширение массива (Arrays.copyOf)
        int[] expandedNumbers = Arrays.copyOf(numbers, 8);
        System.out.println("Расширенный массив (с нулями в конце): " + Arrays.toString(expandedNumbers));

        // Демонстрация ссылочной природы (Reference Types)
        int[] originalRef = {1, 2, 3};
        int[] copyRef = originalRef; // Копируется ССЫЛКА, а не сами данные!
        copyRef[0] = 99;

        System.out.println("originalRef[0] тоже стал: " + originalRef[0]);
    }
}