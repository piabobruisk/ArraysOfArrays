package by.epam.pia.learning.algorithmization.arraysofarrays;

//4. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
//[1,   2,... n]
//[n, n-1,... 1]
//[1,   2,... n]
//..............
//[n, n-1,... 1]

import java.util.Arrays;
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {

        int n;
        int[][] a;
        int[] evenArray;
        int[] oddArray;

        do {
            n = input("Введите размерность матрицы n(>1, четное)=");
        } while (n < 2 || n % 2 != 0);

        a = new int[n][n];
        evenArray = createEvenArray(n);
        oddArray = createOddArray(n);

        System.out.println("Результат работы:");
        for (int i = 0; i < n; i += 2) {
            a[i] = Arrays.copyOf(evenArray, n);
            System.out.println(Arrays.toString(a[i]));
            a[i + 1] = Arrays.copyOf(oddArray, n);
            System.out.println(Arrays.toString(a[i + 1]));
        }
    }

    private static int[] createEvenArray(int n) {

        int[] a;
        a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }

        return a;
    }

    private static int[] createOddArray(int n) {

        int[] a;
        a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = n - i;
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
