package oop.polymorphism;

public class Main {

    static void main() {

        Mail mail = new Dove("Кристине", "Жени", "Люблю тебя");
        Mail mail1 = new Telegraf("Жени", "Кристине", "Я ещё тот дурашка");

        mail.send();
        mail.massege();
        mail1.send();
        mail1.massege();

    }

}

abstract class Messege implements Mail{

    private String from;
    private String to;
    private String text;
    public Messege(String from, String to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
    }



    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getText() {
        return text;
    }
}

class Dove extends Messege{
    public Dove(String from, String to, String text){
        super(from, to, text);
    }

    @Override
    public void massege(){
        System.out.println("Письмо от: " + getFrom() + ", для: " + getTo() + ". Текст: " + getText());
    }

    @Override
    public void send(){
        System.out.println("Отправить голубем");
    }
}
class Telegraf extends Messege {

    public Telegraf(String from, String to, String text) {
        super(from, to, text);
    }

    @Override
    public void massege() {
        System.out.println("Письмо от: " +  getFrom() + ", для: " + getTo()  + ". Текст: " +  getText());
    }

    @Override
    public void send(){
        System.out.println("Отправить телеграмой");
    }
}


interface Mail{
    void massege();
    void send();
}
