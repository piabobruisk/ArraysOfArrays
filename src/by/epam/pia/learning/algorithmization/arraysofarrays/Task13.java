package by.epam.pia.learning.algorithmization.arraysofarrays;

//13. Отсотрировать стобцы матрицы по возрастанию и убыванию значений эементов.
/*
    Инициализация матрицы:
        [-4,  5, -8,  9,  0]
        [ 3,  4, -3,  8, -3]
        [ 3,  0,  2,  5, -5]
        [-3, -6, -9, -5, -3]
        [ 0,  2, -8, -9, -6]
        Результат работы:
        [-4,  5, -9,  9, -6]
        [-3,  4, -8,  8, -5]
        [ 0,  2, -8,  5, -3]
        [ 3,  0, -3, -5, -3]
        [ 3, -6,  2, -9,  0]
*/

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task13 {

    private static final int RANGE = 20;

    public static void main(String[] args) {

        int n;
        int[][] a;
        boolean even;

        do {
            n = input("Введите размерность матрицы n(>1)=");
        } while (n < 2);

        a = createSquareMatrix(n);

        for (int column = 0; column < n; column++) {
            even = (column % 2 == 0); // четное - сортировка по возрастанию.
            // сортировка вставками.
            for (int i = 1; i < a.length; i++) {
                for (int j = i; j > 0; j--) {
                    // тут в зависимости от четности стобца инвертирую направление сортировки
                    if (even ^ (a[j - 1][column] < a[j][column])) {

                        int tmp = a[j - 1][column];
                        a[j - 1][column] = a[j][column];
                        a[j][column] = tmp;

                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println("Результат работы:");
        for (int i = 0; i < a.length; i++) System.out.println(Arrays.toString(a[i]));
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
