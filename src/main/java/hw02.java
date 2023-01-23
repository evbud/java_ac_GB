//Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).
//Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга (вхождение в обратном порядке).
//*Напишите программу, чтобы перевернуть строку с помощью рекурсии. -
//Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168
//Используем метод StringBuilder.append().
//Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
//*Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
//**Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.

public class hw02 {

    public static void main(String[] args) {

        String str1 = "Hello hello hello hello";
        String str2 = "ell";
        contain(str1, str2);
        contain(str1, new StringBuilder(str2).reverse().toString());

        int i1 = 3;
        int i2 = 56;

        StringBuilder sb1 = new StringBuilder();
        sb1.append(i1).append(" + ").append(i2).append(" = ").append(i1+i2);

        StringBuilder sb2 = new StringBuilder();
        sb2.append(i1).append(" - ").append(i2).append(" = ").append(i1-i2);

        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println(new StringBuilder().append(i1).append(" * ").append(i2).append(" = ").append(i1*i2));

        sb1.insert(8, "равно").deleteCharAt(7);
        System.out.println(sb1);

        sb2.replace(7, 8, "равно");
        System.out.println(sb2);

        String eq = "=".repeat(10000);
        System.out.println(eq);
        StringBuilder eqSb = new StringBuilder(eq);

        double begin = System.currentTimeMillis();
        eq = eq.replace("=", "равно");
        System.out.println(System.currentTimeMillis() - begin);
        System.out.println(eq);

        begin = System.currentTimeMillis();
        for (int i = 0; i < eqSb.length(); i++) {
            if (eqSb.charAt(i) == '=') {
                eqSb = eqSb.replace(i,i+1,"равно");
            }
        }
        System.out.println(System.currentTimeMillis() - begin);
        System.out.println(eqSb);
    }

    public static void contain(String s1, String s2) {
        System.out.println(s1.contains(s2));
    }
}