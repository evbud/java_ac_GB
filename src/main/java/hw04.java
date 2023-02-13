//1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль
// используя классы FileWriter и FileReader
//2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы.
//Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М"
//3.Загруженный и разбитый по строкам текст загрузить в подготовленные списки.
//Фамилии, имена, отчества, возраст и пол в отдельных списках.
//4.Отсортировать по возрасту используя дополнительный список индексов.

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class hw04 {
    public static void main(String[] args) {

        ArrayList<String> family = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> soname = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        LinkedList<Integer> index = new LinkedList<>();

        String str = "";
        try {
//            FileWriter writer = new FileWriter("db.txt");
//            writer.append("Иванов Иван Иванович 32 М\n" +
//                    "Петров Петр Петрович 33 М\n" +
//                    "Сидоров Иван Григорьевич 29 М\n" +
//                    "Петрова Ольга Олеговна 30 Ж\n" +
//                    "Григорьев Сесргей Сергеевич 31 М\n" +
//                    "Михайлова Инна Ивановна 35 Ж\n" +
//                    "Козлова Анна Ивановна 28 Ж");
//            writer.flush();

            FileReader reader = new FileReader("db.txt");
            while (reader.ready()) {
                str += (char)reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] temp = str.split("\n");
        System.out.println(Arrays.toString(temp));
        for (int i = 0; i < temp.length; i++) {
            String[] tmp = temp[i].split(" ");
            family.add(tmp[0]);
            name.add(tmp[1]);
            soname.add(tmp[2]);
            age.add(Integer.valueOf(tmp[3]));
            gender.add(tmp[4].equals("Ж")?true:false);
            index.add(i);
        }

        for (int i = 0; i < index.size(); i++) {
            System.out.println(family.get(index.get(i))+" "+name.get(i).charAt(0)+"."+soname.get(i).charAt(0)+"."+" "+age.get(i)+" "+(gender.get(i)?"Ж":"М"));
        }

        ArrayList<Integer> tmp = new ArrayList<>(age);
        Collections.sort(tmp);
        for (int i = 0; i < tmp.size(); i++) {
            int j = age.indexOf(tmp.get(i));
            index.set(i, j);
        }
    }
}