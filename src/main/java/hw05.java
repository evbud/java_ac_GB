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
        hashMap.putIfAbsent(4, "Сидоров Геннадий Петрович, 33 м");
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
    }
}