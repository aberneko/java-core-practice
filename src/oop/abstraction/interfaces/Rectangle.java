package oop.abstraction.interfaces;

public class Rectangle extends Parallelogram {
    private final double b;

    public Rectangle(double a, double b) {
        super(a); // Передаём сторону 'a' в родительский класс Parallelogram
        this.b = b;
    }

    @Override
    public double getArea() {
        return getA() * b;
    }
}