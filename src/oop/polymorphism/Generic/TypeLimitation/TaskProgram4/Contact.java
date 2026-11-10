package oop.polymorphism.Generic.TypeLimitation.TaskProgram4;

// дополните объявление класса Contact
abstract class Contact {
    // класс должен содержать одно полe — имя пользователя name
    private String name;

    public Contact(String name){
        this.name = name;
    }
    // и два три метода — getName(), sendMessage() для отправки сообщения и print() для печати информации о контакте
    public String getName(){
        return name;
    }

    abstract void sendMessage();
    abstract void print();
}
