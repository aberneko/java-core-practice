package oop.abstraction;

public class Main {
    static void main() {

        //Animal animal = new Animal();

        Cat cat = new Cat("Нацу");
        Dog dog = new Dog("Херус");



        System.out.println(cat.getName());
       // System.out.println(dog.name);

       cat.say();
       dog.say();
    }
}

abstract class Animal{
    private String name;
    int age;

    public Animal(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void say(){
        System.out.println("fewfwe");
    }

    public abstract void eat();
}

class Cat extends Animal{

    public Cat(String name){
        super(name);
    }

    @Override
    public void say(){
        System.out.println("fwefwefwef");
    }

    @Override
    public void eat(){
        System.out.println("Я ем говно");
    }
}

class Dog extends Animal{

    public Dog(String name){
        super(name);
    }

    @Override
    public void say(){
        System.out.println("Гав");
    }

    @Override
    public void eat(){
        System.out.println("Я тоже ем говно");
    }
}


class Main1{
    static void main() {
        Gmail gmail = new Gmail();
        Twitter twitter = new Twitter();

        gmail.notifyUser("хуй");
        twitter.notifyUser("хуй");
    }
}

abstract class Notifier{

    public void notifyUser(String massage) {
        String format = "[Уведомление]: " + massage;
        send(format);
    }

    public abstract void send(String message);

}

class Gmail extends Notifier{
    @Override
    public void send(String message){
        System.out.println("Отправка по email: " + message);
    }
}

class Twitter extends Notifier{
    @Override
    public void send(String message){
        System.out.println("Отправка по Twitter: " + message);
    }
}
