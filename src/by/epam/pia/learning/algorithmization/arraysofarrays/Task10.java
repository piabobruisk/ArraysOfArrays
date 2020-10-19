package by.epam.pia.learning.algorithmization.arraysofarrays;

//10. Найти положительные элементы главной диагонали квадратной матрицы.

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task10 {

    private static final int RANGE = 20;

    public static void main(String[] args) {

        int n;
        int[][] a;

        do {
            n = input("Введите размерность матрицы n(>1)=");
        } while (n < 2);

        a = createSquareMatrix(n);

        for (int i = 0; i < n; i++) {
            if (a[i][i] > 0) {
                System.out.println("Элемент " + i + " - " + i + " = " + a[i][i] + " положительный");
            }
        }
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
