package oop.polymorphism.Generic.TypeLimitation.TaskProgram3;

public class HardQuestion implements SmartPrintable {

    String questionText;

    public HardQuestion(String questionText) {
        this.questionText = questionText;
    }

    @Override
    public void printSmart() {
        System.out.println("Текст очень сложного вопроса: " + questionText);
    }
}
