package oop.polymorphism.Generic.TypeLimitation;

public class InterfeceTypeLimit {
    static void main() {

        // Сабтайпинг
        // Минус: можно вызвать только методы интерфейса, собственные методы класса реализовающие интерфейс не получится вызвать
        Technic technic = new WashingMachine("Стиральная машина");
        Technic technic2 = new Computer("Компьютер");

        // можно написать так для доступа к методам класса
        WashingMachine washingMachine = new WashingMachine("Стиральная машина");
        Computer computer = new Computer("Компьютер");

        // Объект с параметром типо Technic для вывода метода в который можно подставить ограничение по верхней границы extends Technic
        // Если мы передаём объекты Technic то смотря какие они вызваны через тип интерфейса или через свой класс к слову для использования других методов
        ServiceCenter<Technic> serviceCenter = new ServiceCenter<>();
        serviceCenter.testDevice(technic);
        serviceCenter.testDevice(technic2);
        serviceCenter.testDevice(washingMachine);
        serviceCenter.testDevice(computer);

        ServiceCenter<WashingMachine> serviceCenterWM = new ServiceCenter<>();
        serviceCenterWM.testDevice(washingMachine);
        ServiceCenter<Computer> serviceCenterCM = new ServiceCenter<>();
        serviceCenterCM.testDevice(computer);

        System.out.println(max(washingMachine, computer).getName());
    }

    public static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) > 0 ? a : b;
    }
}

interface Technic{
    public void run();
}

class WashingMachine extends ServiceCenterMain implements Technic{

    public WashingMachine(String name){
        super(name);
    }

    @Override
    public void run(){
        System.out.println("Машина запустилась");
    }

}

class Computer extends ServiceCenterMain implements Technic{

    public Computer(String name){
        super(name);
    }

    @Override
    public void run(){
        System.out.println("Компьютер запустился");
    }

}
// как я понял так как мы передаём в метод ссылку на объект мы можем вызвать метод класса если мы в вызове создавали объект класса, но если через тип интерфейса то только метод интерфейса
class ServiceCenter<T extends Technic>{
    public void testDevice(T device){
        device.run();
    }
}

abstract class ServiceCenterMain implements Comparable<ServiceCenterMain>{
    private final String name;

    public ServiceCenterMain(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public int compareTo(ServiceCenterMain o) {
        return this.name.compareTo(o.getName());
    }
}


