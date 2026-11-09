package arrays;

public class CurrencyArrayDemo {

    void main() {

        String[] currencies = {"USD", "EUR", "JPY", "RUB"}; // массив
        // цикл начинается с 0 и продолжается c шагом в единицу, пока i строго меньше длины массива
        for (int i = 0; i < currencies.length; i++) {
            // переменная итерирования ставится на место индекса, так все элементы будут напечатаны
            System.out.println("Поддерживаемая валюта: " + currencies[i]);
        }

    }

}
