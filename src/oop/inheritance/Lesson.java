package oop.inheritance;

public class Lesson {
    String name;
    int numberOfLessons;

    public Lesson(String name, int numberOfLessons) {
        this.name = name;
        this.numberOfLessons = numberOfLessons;
    }

    protected void startLesson(){
        System.out.println("Звонок прозвинел");
    }
}
