package algorithmization;
import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    public static void main(String[] args) {
        int[] array = scannerInt();
        System.out.print("Введите искомое число: ");
        int numberIndex = scanner.nextInt();
        System.out.print("Индекс искомого элемента: " + find(array, numberIndex));

        randomNumberSearch();

    }

    public static int find(int[] array, int elem) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (elem == array[i]) {
                index = i;
                break;
            }
        }
        return index;

    }
    // Нужно написать метод, который на вход принимает массив чисел и значение, которое нужно найти. Необходимо вернуть индекс искомого элемента.
    public static int[] scannerInt() {
        System.out.print("Введите массив чисел через пробел: ");
        String line = scanner.nextLine();
        String[] token = line.trim().split("\\s+");
        int[] array = new int[token.length];
        for (int i = 0; i < token.length; i++) {
            array[i] = Integer.parseInt(token[i]);
        }
        return array;
    }
    // Игра угадай число
    public static void randomNumberSearch() {
        int target = random.nextInt(1000) + 1;
        System.out.println("Я загадал число. Попробуйте угадать!");
        while (true) {
            int number = scanner.nextInt();
            if (number < target) {
                System.out.println("Ваше число меньше");
            } else if (number > target) {
                System.out.println("Ваше число больше");
            } else {
                System.out.println("Правильный ответ");
                break;
            }
        }
    }
}


