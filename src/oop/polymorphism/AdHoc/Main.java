package oop.polymorphism.AdHoc;

import java.util.Arrays;

public class Main {
    static void main() {
        int[] arr = new int[]{1, 3, 4, 5};
        Printer printer = new Printer();
        printer.print(5);
        printer.print("fe");
        printer.print(1,2);
        printer.print(arr);

    }
}

class Printer{

    public void print(int value){
        System.out.println(value);
    }

    public void print(String value){
        System.out.println(value);
    }

    public void print(int a, int b){
        System.out.println(a+b);
    }

    public void print(int[] arr){
        System.out.println("Вывели ваш массив " + Arrays.toString(arr));
    }



}