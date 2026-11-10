package methods;

public class MemoryDemo {
    void main(){

        Person person = new Person("[eq", 45); // person хранит ссылку на объект в стеке
        int age = 56; // значение хранится в стеке
        age = need2(person, age); // создаётся отдельный временный фрейм

        System.out.println(age); // выводится результат локальной переменной этого фрейма

        person = need(person, age);
        System.out.println(person.age + person.name);

    }

    public static Person need(Person person, int age){ // наш новый фрейм с параметрами в которые копируется для ссылочного объекта ссылка на значение в куче а для примитива копируется само значение
        person = new Person("sdfsdf", 323); // в переменную которая хранит копию ссылки на объект заносим новую ссылку на другой объкт
        age = 10;
        return person;
    }

    public static int need2(Person person, int age){ // наш новый фрейм с параметрами в которые копируется для ссылочного объекта ссылка на значение в куче а для примитива копируется само значение
        person = new Person("sdfsdf", 323); // в переменную которая хранит копию ссылки на объект заносим новую ссылку на другой объкт
        person.age = 90;
        age = 10;
        return age;
    }

    public static class Person {
        String name;
        int age;
        Person  (String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

}
