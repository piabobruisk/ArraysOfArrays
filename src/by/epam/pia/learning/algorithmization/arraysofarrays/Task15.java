package by.epam.pia.learning.algorithmization.arraysofarrays;

//15. Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task15 {

    private static final int RANGE = 20;

    public static void main(String[] args) {

        int n;
        int[][] a;
        int max;

        do {
            n = input("Введите размерность матрицы n(>1)=");
        } while (n < 2);

        a = createSquareMatrix(n);
        max = maxValue(a);
        System.out.println("Максимальный элемент матрицы:" + max);

        for (int i = 0; i < a.length; i++) {
            if (i % 2 != 0) {

                for (int j = 0; j < a[0].length; j++) {
                    if (j % 2 == 0) a[i][j] = max;
                }

            } else {

                for (int j = 0; j < a[0].length; j++) {
                    a[i][j] = max;
                }

            }
        }

        System.out.println("Результат работы:");
        for (int[] ints : a) System.out.println(Arrays.toString(ints));
    }

    private static int maxValue(int[][] a) {
        int max;
        max = a[0][0];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (max < a[i][j]) max = a[i][j];
            }
        }
        return max;
    }

    private static int[][] createSquareMatrix(int n) {
        Random random;
        random = new Random();
        int[][] a;
        a = new int[n][n];
        System.out.println("Инициализация матрицы:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = random.nextInt(RANGE) - 10;
            }
            System.out.println(Arrays.toString(a[i]));
        }
        return a;
    }

    private static int input(String prompt) {

        Scanner scanner;
        scanner = new Scanner(System.in);

        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
        }
        return scanner.nextInt();
    }
}
