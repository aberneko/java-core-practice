package junittest.Practice;

import java.util.ArrayList;
import java.util.Random;

// Переусложнённая фабрика печенек
public class OvercomplicatedCookieFactory {
    private int cookiesCreated = 0;         // счётчик приготовленных печенек
    private final ArrayList<String> positiveTexts;          // Список для позитивных предсказаний
    private final ArrayList<String> negativeTexts;          // Список для негативных предсказаний
    private final boolean isPositive;           // флаг

    private final Random rnd = new Random();            // класс Random используется, чтобы возвращать случайное предсказание из списка.

    public OvercomplicatedCookieFactory(            // Слишком сложная фабрика печенек
            ArrayList<String> positiveTexts,
            ArrayList<String> negativeTexts,
            boolean isPositive
    ) {
        this.positiveTexts = positiveTexts;
        this.negativeTexts = negativeTexts;
        this.isPositive = isPositive;
    }

    // Печём печеньку
    public String bakeFortuneCookie() {
        StringBuilder cookieBuilder = new StringBuilder();      // сильный объект для экономии места в памяти

        this.incrementNumberOfCookiesCreated();         // увеличиваем счётчик печенек

        if(isPositive) {
            cookieBuilder.append(randomPositive());     // добавляем куски текста в StringBuilder
        } else {
            cookieBuilder.append(randomPositive());
        }

        return cookieBuilder.toString();        // преобразуем в строку

    }

    public int getCookiesCreated(){         // возвращаем количество печенек
        return this.cookiesCreated;
    }

    public void resetCookiesCreated(){      //обнуляем счётчик
        this.cookiesCreated = 0;
    }

    private void incrementNumberOfCookiesCreated() {
        this.cookiesCreated++;
    }

    // Выбираем произвольное предсказание из списка
    private String randomPositive() {
        int randomIndex = rnd.nextInt(positiveTexts.size());        // Получаем целое случайное число от нуля до максимального размера массива - 1.
        return positiveTexts.get(randomIndex);
    }

    private String randomNegative() {
        int randomIndex = rnd.nextInt(negativeTexts.size());
        return negativeTexts.get(randomIndex);
    }

}
