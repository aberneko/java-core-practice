package oop.inheritance;

public class SwimmingLesson extends Lesson {
    private int swimmingLesson;

    public SwimmingLesson(String name, int numberOfLessons, int swimmingLesson) {
        super(name, numberOfLessons);
        this.swimmingLesson = swimmingLesson;
    }

    @Override
    public void startLesson(){
        super.startLesson();
        System.out.println("Стать в строй");
    }

}
