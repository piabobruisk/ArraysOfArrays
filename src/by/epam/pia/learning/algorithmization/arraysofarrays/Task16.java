package by.epam.pia.learning.algorithmization.arraysofarrays;

//16. Магическим квадратом порядка n называется квадратная матрица размера nxn,
//составленная из чисел 1, 2, 3, ..., так, что суммы по каждому столбцу, каждой строке
//и каждой из двух больших диагоналей равны между собой. Построить такой квадрат.

import java.util.Arrays;
import java.util.Scanner;

public class Task16 {

    public static void main(String[] args) {

        int n;
        int[][] magic;

        int x;
        int y;
        // реализация алгоритма только для нечетной матрицы
        do {
            n = input("Введите размерность нечетной матрицы n(>2)=");
        } while (n < 3 || n%2==0); // проверка на нечетность

        magic = new int[n][n];

        //метод французского геометра Лубера
        x = 0;
        y = n / 2;

        for (int i = 1; i <= n * n; i++) {
            magic[x][y] = i;
            int tmpX = x - 1;
            int tmpY = y + 1;
            if (tmpX < 0) tmpX = n - 1;
            if (tmpY > (n - 1)) tmpY = 0;
            if (magic[tmpX][tmpY] != 0) {
                x++;
            } else {
                x = tmpX;
                y = tmpY;
            }
        }

        System.out.println("Результат работы:");
        for (int i = 0; i < magic.length; i++)
            System.out.println(Arrays.toString(magic[i]) + "   Сумма:" + sumRow(magic, i));
        for (int i = 0; i < magic[0].length; i++)
            System.out.println("Сумма столбца " + i + " = " + sumColumn(magic, i));
        System.out.println("Сумма главной диагонали = " + sumMainDiagonal(magic));
        System.out.println("Сумма вспомогательной диагонали = " + sumAuxiliaryDiagonal(magic));
    }

    private static int sumColumn(int[][] a, int column) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i][column];
        }
        return sum;
    }

    private static int sumRow(int[][] a, int row) {
        int sum = 0;
        for (int i = 0; i < a[row].length; i++) {
            sum += a[row][i];
        }
        return sum;
    }

    private static int sumMainDiagonal (int[][] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i][i];
        }
        return sum;
    }

    private static int sumAuxiliaryDiagonal (int[][] a) {
        int sum = 0;
        int len= a.length-1;
        for (int i = 0; i <a.length; i++) {
            sum += a[i][len-i];
        }
        return sum;
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
