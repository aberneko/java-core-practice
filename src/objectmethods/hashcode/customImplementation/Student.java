package objectmethods.hashcode.customImplementation;

import java.util.HashMap;
import java.util.Objects;

class Student {
    String name;
    String lastName;

    public Student(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    static void main() {

        HashMap<Integer, Student> map = new HashMap<>();
        Student student = new Student("Лю", "Сан");
        map.put(1, student);
        Student student1 = new Student("Сан", "Лю");
        boolean isValue = map.containsValue(student1);

        System.out.println(isValue);
        System.out.println(student.hashCode());
        System.out.println(student1.hashCode());

    }

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Student student = (Student) object;
        return Objects.equals(name, student.name) && Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        if(name != null) {
            hash = hash + name.hashCode();
        }

        hash = hash * 31;

        if(lastName != null) {
            hash = hash + lastName.hashCode();
        }

        return hash;
    }
}



