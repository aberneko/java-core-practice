package oop.polymorphism.Generic.TypeLimitation.TaskProgram3;

import java.util.HashMap;

public class AnswerHolder<T extends Number> implements SmartPrintable {
    public String question;
    public T answer;

    public AnswerHolder(String question, T answer) {
        this.question = question;
        this.answer = answer;
    }
    //метод должен замещать значение answer значением, полученным из аргумента - хеш-таблицы, для данного вопроса
    public void replaceAnswer(HashMap<String, ? extends T> answersMap) {
        if (answersMap.containsKey(question)) {
            this.answer = answersMap.get(question);
        }
    }

    @Override
    public void printSmart() {
        System.out.println("Ответ на вопрос '" + question + "' равен " + answer.intValue());
    }

}
