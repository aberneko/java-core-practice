package oop.polymorphism.TaskProgram;

public class Smartphone extends MobilePhone{

    public Smartphone(String number){
        super(number);
    }

    public void makeCall(String targetNumber, String appName){
        System.out.println("Позвоним через приложение " + appName + " по номеру " + targetNumber);
    }

    public final void sendEmail(String messageText, String email){
        System.out.println("Напишем другу сообщение" + messageText + " по email" + email);
    }

}
