package by.epam.pia.learning.algorithmization.arraysofarrays;

//  Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
//[1, 1, 1, 1 ]
//[2, 2, 2, 0 ]
//[3, 3, 0, 0 ]
//[4, 0, 0, 0 ]

import java.util.Arrays;
import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {

        int n;
        int[][] a;

        do {
            n = input("Введите размерность матрицы n(>1, четное)=");
        } while (n < 2 || n % 2 != 0);

        a = new int[n][n];

        System.out.println("Результат работы:");
        for (int i = 0; i < n; i++) {
            a[i] = createArray(i, n);
            System.out.println(Arrays.toString(a[i]));
        }
    }

    private static int[] createArray(int stroke, int n) {

        int[] a;
        a = new int[n];

        for (int i = 0; i < n - stroke; i++) {
            a[i] = stroke + 1;
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
