package by.epam.pia.learning.algorithmization.arraysofarrays;

//12. Отсортировать строки матрицы по возрастанию
//и убыванию значений элементов.

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Task12 {

    private static final int RANGE = 20;

    public static void main(String[] args) {

        //чтобы использовать возможности сортировки класса Arrays использую массив Integer
        int n;
        Integer[][] a;

        do {
            n = input("Введите размерность матрицы n(>1)=");
        } while (n < 2);

        a = createSquareMatrix(n);

        System.out.println("Результат работы:");
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                Arrays.sort(a[i]);
            } else {
                Arrays.sort(a[i], Collections.reverseOrder());
            }
            System.out.println(Arrays.toString(a[i]));
        }
    }

    private static Integer[][] createSquareMatrix(int n) {
        Random random;
        random = new Random();
        Integer[][] a;
        a = new Integer[n][n];
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
