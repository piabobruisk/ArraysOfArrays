package by.epam.pia.learning.algorithmization.arraysofarrays;

//8. В числовой матрице поменять местами два столбца любых столбца, т. е.
//все элементы одного столбца поставить на соответствующие им позиции другого,
//а его элементы второго переместить в первый. Номера столбцов вводит пользователь с клавиатуры.

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task8 {

    private static final int RANGE = 20;

    public static void main(String[] args) {

        int n;
        int[][] a;
        int p1;
        int p2;

        do {
            n = input("Введите размерность матрицы n(>1)=");
        } while (n < 2);

        do {
            p1 = input("Введите первый столбец матрицы p1(1..." + n + ")=");
        } while (p1 < 1 || p1 > n);

        do {
            p2 = input("Введите второй столбец матрицы p1(1..." + n + ")=");
        } while (p2 < 1 || p2 > n);

        a = createSquareMatrix(n);

        if (p1==p2) {
            System.out.println("Перестановка выполнена без замены.");
        }else {
            int tmp;
            System.out.println("Результат работы:");
            for (int i = 0; i < n; i++) {
                tmp = a[i][p1-1];
                a[i][p1-1] = a[i][p2-1];
                a[i][p2-1] = tmp;
                System.out.println(Arrays.toString(a[i]));
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
