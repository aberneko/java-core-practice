package oop.polymorphism.Generic.TypeLimitation.TaskProgram3;

import java.util.ArrayList;
import java.util.HashMap;

public class Practicum {
    static void main() {
        System.out.println("ВОПРОСЫ НА КОТОРЫЕ ДАНЫ НЕ ПРАВИЛЬНЫЕ ОТВЕТЫ: ");
        AnswerHolder<Number> elephantAnswer = new AnswerHolder<>("Сколько весит слон в тоннах", 5);
        elephantAnswer.printSmart();
        AnswerHolder<Number> elephantAnswer1 = new AnswerHolder<>("Сколько звёзд на небе ?", 5);
        elephantAnswer1.printSmart();


        HashMap<String, Double> bigRussianEncyclopedia = new HashMap<>();
        bigRussianEncyclopedia.put("Сколько часов в сутках", (double) 24);
        bigRussianEncyclopedia.put("Сколько весит слон в тоннах", 4.3);

        HashMap<String, Integer> bigRussianEncyclopediaInteger = new HashMap<>();
        bigRussianEncyclopediaInteger.put("Сколько звёзд на небе ?", 585);


        elephantAnswer.replaceAnswer(bigRussianEncyclopedia);
        elephantAnswer.printSmart();

        elephantAnswer1.replaceAnswer(bigRussianEncyclopediaInteger);
        elephantAnswer1.printSmart();

        HardQuestion elephantVolumeQuestion = new HardQuestion("Как вычислить объём слона с помощью подручных средств?");
        elephantVolumeQuestion.printSmart();

        ArrayList<SmartPrintable> printables = new ArrayList<>();
        printables.add(elephantAnswer);
        printables.add(elephantVolumeQuestion);
        System.out.println("Всё, что можно распечатать: ");
        print(printables);

        ArrayList<AnswerHolder<Number>> answers = new ArrayList<>();
        answers.add(elephantAnswer);
        System.out.println("Лучшие ответы на вопросы: ");
        print(answers);
    }

    public static void print(ArrayList<? extends SmartPrintable> arrayList){
        for(SmartPrintable smartPrintable : arrayList){
            smartPrintable.printSmart();
        }
    }
}
