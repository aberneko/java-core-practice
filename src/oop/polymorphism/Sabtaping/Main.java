package oop.polymorphism.Sabtaping;

public class Main {
    static void main() {
        Teacher teacher = new Teacher("Кристина");
        print(teacher);
        teacher.print();

        Person pers = new Teacher("Женя");
        System.out.println(pers.getName());

        Developer developer = new Developer("Нацу");
        System.out.println(developer.getName());
        developer.print();
        System.out.println(developer.getSalary());
        developer.work();

        Task task = new Developer("Субару");
        System.out.println(task.getSalary());
        task.work();
    }

    public static void print(Person person){
        System.out.println("Ваше имя: " + person.getName());
    }
}

class Person{
    private String name;

    public Person(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}


class Teacher extends Person{

    public Teacher(String name){
        super(name);
    }

    public void print(){
        System.out.println("Привет класс");
    }

}

class Developer extends Person implements Task{

    private double salary = 1000000;

    public Developer(String name){
        super(name);
    }

    @Override
    public void work(){
        System.out.println("Начало работы");
    }

    @Override
    public double getSalary(){
       return salary;
    }

    public void print(){
        System.out.println("gjrf");
    }
}

interface Task{
    void work();
    double getSalary();
}