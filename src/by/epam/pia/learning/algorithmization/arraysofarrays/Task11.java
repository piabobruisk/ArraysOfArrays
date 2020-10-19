package by.epam.pia.learning.algorithmization.arraysofarrays;

//11. Матрицу 10x20 заполнить случайными числами от 0 до 15.
//Вывести на экран саму матрицу и номера строк, в которых число 5 встречается три и более раз.

import java.util.Arrays;
import java.util.Random;

public class Task11 {

    private static final int RANGE = 15;

    public static void main(String[] args) {

        int[][] a;

        a = createMatrix(10, 20);

        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 5) {
                    sum++;
                }
            }
            if (sum >= 3) {
                System.out.println("Количество вхождений числа 5 в строке " + (i + 1) + " :" + sum);
            }
        }
    }

    private static int[][] createMatrix(int stroke, int column) {
        Random random;
        random = new Random();
        int[][] a;
        a = new int[stroke][column];
        System.out.println("Инициализация матрицы:");
        for (int i = 0; i < stroke; i++) {
            for (int j = 0; j < column; j++) {
                a[i][j] = random.nextInt(RANGE);
            }
            System.out.println(Arrays.toString(a[i]));
        }
        return a;
    }
}
