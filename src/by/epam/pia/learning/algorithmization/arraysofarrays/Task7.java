package by.epam.pia.learning.algorithmization.arraysofarrays;

//Сформировать квадратную матрицу порядка N по правилу:
//A[i,j]=sin((i*i-j*j)/N)
//и подсчитать количество положительных элементов в ней.

import java.util.Arrays;
import java.util.Scanner;

public class Task7 {

    public static void main(String[] args) {

        int n;
        double[][] a;

        do {
            n = input("Введите размерность матрицы n(>1)=");
        } while (n < 2);

        a = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = Math.sin((double) (i * i - j * j) / n);
            }
        }

        int sum;
        sum = 0;

        System.out.println("Результат работы:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] > 0) sum++;
            }
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println("Положительных элементов:" + sum);
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
