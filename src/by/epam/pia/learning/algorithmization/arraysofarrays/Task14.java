package by.epam.pia.learning.algorithmization.arraysofarrays;

//14. Сформировать случайную матрицу m x n, состоящую из нулей и единиц,
//причем в каждом столбце число единиц равно номеру столбца.
/*Результат работы:
        [1, 0, 0, 0, 1, 1, 1, 1]
        [0, 0, 0, 1, 1, 0, 1, 1]
        [0, 1, 1, 1, 1, 1, 0, 1]
        [0, 1, 1, 0, 1, 1, 1, 1]
        [0, 0, 0, 1, 0, 1, 1, 1]
        [0, 0, 0, 0, 0, 1, 1, 1]
        [0, 0, 1, 0, 1, 1, 1, 1]
        [0, 0, 0, 1, 0, 0, 1, 1]
*/

import java.util.Arrays;
import java.util.Random;

public class Task14 {

    private static final int RANGE = 9;

    public static void main(String[] args) {

        int[][] a;
        int m;
        int n;
        int[] indexes;
        Random random;

        random = new Random();
        m = random.nextInt(RANGE) + 2;

        do {
            n = random.nextInt(RANGE) + 2;
        } while (n > m);

        a = new int[m][n];
        // инициализация массива индексов
        indexes = new int[m];
        for (int i = 0; i < m; i++) indexes[i] = i;


        System.out.println("Инициализация матрицы размером " + m + "x" + n);
        //погнали
        for (int i = 0; i < n; i++) {
            randomizeIndexArray(indexes);
            for (int j = 0; j <= i; j++) {
                a[indexes[j]][i] = 1;
            }
        }

        System.out.println("Результат работы:");
        for (int i = 0; i < a.length; i++) System.out.println(Arrays.toString(a[i]));
    }

    private static int[] randomizeIndexArray(int[] ind) {

        int j;
        int range;
        Random random;

        range = ind.length;
        random = new Random();

        for (int i = 0; i < range; i++) {
            j = random.nextInt(range);
            int tmp = ind[i];
            ind[i] = ind[j];
            ind[j] = tmp;
        }
        return ind;
    }
}

