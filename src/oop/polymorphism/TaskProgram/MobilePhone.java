package oop.polymorphism.TaskProgram;

public class MobilePhone extends Phone{

    public MobilePhone(String number){
        super(number);
    }

    public final void sendSms(String messageText, String targetNumber){
        System.out.println("Напишем другу сообщение" + messageText + " по email" + targetNumber);
    }


}
