package datatypes;

public class TypeParsingDemo {
    void main(){

        // Парс строк
        String numberString = "123";
        int numberInt = Integer.parseInt(numberString);
        int numberInt2 = Integer.parseInt("1234");
        boolean word = Boolean.parseBoolean("true");


        System.out.println(numberString + " строка");
        System.out.println(numberInt + " целочисленное интовое значение");
        System.out.println(numberInt2 + " целочисленное значение");
        System.out.println(word);

        // Поиск минимума и максимума
        long maximum = Long.max(100L, 500L); // вернет 500L
        double minimum = Double.min(0.05, 0.01); // вернет 0.01

        // Приведение типов
        Integer numberColl = 34;
        byte numberColl2 = numberColl.byteValue();
        System.out.println(numberColl2);

        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b); // true, так как взяты из кэша (один объект)

        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d); // false, так как это два разных объекта в куче

        Integer x = Integer.valueOf(100);

        int max = Integer.MAX_VALUE; // 2_147_483_647
        int min = Integer.MIN_VALUE; // -2_147_483_648
        long maxLong = Long.MAX_VALUE;

        int sum = 1 + max;
        System.out.println(sum);

        int result = Integer.compare(10, 20); // Вернет -1 (первое меньше второго)
        int maxInt = Integer.max(10, 20); // Вернет 20
        int sumInt = Integer.sum(10, 20); // Вернет 30

        System.out.println(result);
        System.out.println(maxInt);
        System.out.println(sumInt);

        String binary = Integer.toBinaryString(10); // "1010"
        String hex = Integer.toHexString(255); // "ff"

        System.out.println(binary);
        System.out.println(hex);

        Character.isDigit('5'); // true (это цифра?)
        Character.isLetter('A'); // true (это буква?)
        Character.isWhitespace(' '); // true (это пробел?)
        Character.toUpperCase('a'); // 'A'
        Character.toLowerCase('A'); // 'a'

        boolean b1 = Boolean.parseBoolean("true"); // true
        boolean b2 = Boolean.parseBoolean("TRue"); // true (регистронезависимый)
        boolean b3 = Boolean.parseBoolean("yes"); // false (всё, что не "true", это false)




    }

}


