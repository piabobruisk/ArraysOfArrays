package by.epam.pia.learning.algorithmization.arraysofarrays;

//3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы.

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task3 {

    private static final int RANGE = 20;

    public static void main(String[] args) {

        int n;
        int[][] a;
        int k;
        int p;

        do {
            n = input("Введите размерность матрицы n(>1)=");
        } while (n < 2);

        do {
            k = input("Введите строку матрицы k(1..." + n + ")=");
        } while (k < 1 || k > n);

        do {
            p = input("Введите столбец матрицы p(1..." + n + ")=");
        } while (p < 1 || p > n);

        a = createSquareMatrix(n);

        System.out.print("Строка " + k + " : ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[k - 1][i] + ", ");

        }
        System.out.println("\b\b");

        System.out.print("Столбец " + p + " : ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i][p - 1] + ", ");
        }
        System.out.println("\b\b");
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
