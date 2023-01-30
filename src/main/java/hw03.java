//1 Объявить два списка список ArrayList, в каждый добавить по 20 случайных чисел.
//Удалить из первого списка элементы отсутствующие во втором списке.
//Отсортировать первый список методом sort класса Collections.
//2 * Отсортировать второй список методом sort списка и компаратором по уменьшению.
//3 **Отсортировать первый список пузырьковой сортировкой самостоятельно, без использования доп методов и классов.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class hw03 {
    public static void main(String[] args) {

        ArrayList arLst1 = getArrayList(20, 100);
        System.out.println(arLst1);

        ArrayList arLst2 = getArrayList(20, 100);
        System.out.println(arLst2);

        System.out.println(deleteMissing(arLst1, arLst2));

        Collections.sort(arLst1);
        System.out.println(arLst1);

        arLst2.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(arLst2);

        System.out.println(sortList(arLst1)); //3**
    }

    private static ArrayList<Integer> getArrayList(int n, int m) {
        ArrayList<Integer> arLst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arLst.add(getRandom(m));
        }
        return arLst;
    }

    private static int getRandom(int n) {
        return new Random().nextInt(n);
    }

    private static ArrayList<Integer> deleteMissing(ArrayList<Integer> aL1, ArrayList<Integer> aL2) {
        aL1.retainAll(aL2);
        return aL1;
    }

    public static ArrayList<Integer> sortList(ArrayList<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(j) > temp){
                    list.set(i, list.get(j));
                    list.set(j, temp);
                    temp = list.get(i);
                }
            }
        }
        return list;
    }
}