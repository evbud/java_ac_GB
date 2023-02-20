//Разработать программу, имитирующую поведение коллекции HashSet.
//В программе содать метод add добавляющий элемент,
//и метод позволяющий выводить эллементы коллекции в консоль. Формат данных Integer.


import java.util.HashMap;
import java.util.Iterator;

public class hw06 {

    private static HashMap<Integer, Object> hMap = new HashMap<>();
    private static final Object OBJ = new Object();

    public static void main(String[] args) {
        add(3);
        add(1);
        add(3);
        add(3);
        add(7);
        add(14);
        add(0);
        System.out.println(hMap.keySet());
        System.out.println(getString());

        Iterator<Integer> iterator = hMap.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Object[] tmp = hMap.keySet().toArray();
        for (int i = 0; i < tmp.length; i++) {
            System.out.println((Integer)tmp[i]);
        }
    }

    public static void add(Integer number) {
        hMap.put(number, OBJ);
    }

    public static String getString() {
        return hMap.keySet().toString();
    }
}