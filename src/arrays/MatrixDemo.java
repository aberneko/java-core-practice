package arrays;

public class MatrixDemo {
    public static void main(String[] args) {
        // двумерный массив
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("--- Вывод матрицы по строкам и столбцам ---");
        // Вложенные циклы для обхода матрицы: i — строка, j — столбец
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println(); // Переход на новую строку после каждой строки матрицы
        }
    }
}