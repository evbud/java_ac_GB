//Создать словарь HashMap. Обобщение <Integer, String>.
//Заполнить пятью ключами (индекс, ФИО+Возраст+Пол "Иванов Иван Иванович 28 м"), добавить ключ, если не было!)
//Изменить значения сделав пол большой буквой.
//Пройти по коллекции и вывести значения в формате Фамилия инициалы "Иванов И.И."
//*Сортировать значения по возрасту и вывести отсортированную коллекция как в четвёртом пункте.

import java.util.*;

public class hw05 {
    public static void main(String[] args) {

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.putIfAbsent(1, "Иванов Иван Иванович 28 м");
        hashMap.putIfAbsent(2, "Петров Петр Петрович 30 м");
        hashMap.putIfAbsent(3, "Ольгина Ольга Олеговна 31 ж");
        hashMap.putIfAbsent(4, "Сидоров Геннадий Петрович 33 м");
        hashMap.putIfAbsent(5, "Иванова Анна Витальевна 27 ж");
        System.out.println(hashMap);

        Set<Integer> keySet = hashMap.keySet();
        Collection<String> sValues = hashMap.values();
        Set<Map.Entry<Integer, String>> eSet = hashMap.entrySet();

        ArrayList<String> family = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> soname = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        LinkedList<Integer> index = new LinkedList<>();

        for (int i = 0; i < keySet.size(); i++) {
            String[] string = hashMap.get(keySet.toArray()[i]).split("\n");
            for (int j = 0; j < string.length; j++) {
                String[] tmp = string[j].split(" ");
                String toUpper = tmp[0] + " " + tmp[1] + " " + tmp[2] + " " + tmp[3] + " " + tmp[4].toUpperCase();
                hashMap.put(i+1, toUpper);
            }
        }

        System.out.println(hashMap);

        for (int i = 0; i < keySet.size(); i++) {
            String[] string = hashMap.get(keySet.toArray()[i]).split("\n");
            for (int j = 0; j < string.length; j++) {
                String[] tmp = string[j].split(" ");
                System.out.println(tmp[0] + " " + tmp[1].charAt(0) + "." + tmp[2].charAt(0) + ".");
            }
        }

        for (int i = 0; i < keySet.size(); i++) {
            String[] string = hashMap.get(keySet.toArray()[i]).split("\n");
            for (int j = 0; j < string.length; j++) {
                String[] tmp = string[j].split(" ");
                family.add(tmp[0]);
                name.add(tmp[1]);
                soname.add(tmp[2]);
                age.add(Integer.valueOf(tmp[3]));
                gender.add(tmp[4].equals("Ж")?true:false);
                index.add(i);
            }
        }

        ArrayList<Integer> tmp = new ArrayList<>(age);
        Collections.sort(tmp);
        for (int i = 0; i < tmp.size(); i++) {
            int j = age.indexOf(tmp.get(i));
            index.set(i, j);
        }

        for (int i = 0; i < index.size(); i++) {
            System.out.printf(family.get(index.get(i))+" ");
            System.out.printf(String.valueOf(name.get(index.get(i)).charAt(0))+".");
            System.out.printf(String.valueOf(soname.get(index.get(i)).charAt(0))+".");
            System.out.println();
        }
    }
}