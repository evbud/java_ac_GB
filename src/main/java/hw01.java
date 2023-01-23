//1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
//2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
//3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
//4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
//*Пункты реализовать в разных методах

import java.util.Arrays;
import java.util.Random;

public class hw01 {

    public static void main(String[] args) {
        int i = getRandom();
        int n = getMaxBit(i);
        int[] m1 = findMultiplies(i, n);
        int[] m2 = findNonMultiplies(i, n);

        System.out.println(i);
        System.out.println(n);
        System.out.println(Arrays.toString(m1));
        System.out.println(Arrays.toString(m2));
    }
    private static int getRandom() {
        return new Random().nextInt(2001);
    }

    private static int getMaxBit(int i) {
        return Integer.toBinaryString(i).length();
    }

    private static int[] findMultiplies(int i, int n) {
        int c = 0;
        for (int j = i; j < Short.MAX_VALUE; j++) {
            if (j%n == 0) c++;
        }

        int[] a = new int[c];
        c = 0;
        for (int j = i; j < Short.MAX_VALUE; j++) {
            if (j%n == 0) a[c++] = j;
        }

        return a;
    }

    private static int[] findNonMultiplies(int i, int n) {
        int c = 0;
        for (int j = Short.MIN_VALUE; j < i; j++) {
            if (j%n != 0) c++;
        }

        int[] a = new int[c];
        c = 0;
        for (int j = Short.MIN_VALUE; j < i; j++) {
            if (j % n != 0) a[c++] = j;
        }

        return a;
    }
}