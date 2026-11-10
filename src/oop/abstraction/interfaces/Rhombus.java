package oop.abstraction.interfaces;

public class Rhombus extends Parallelogram {
    // Длина стороны ромба
    // Высота ромба
    private final double h;

    public Rhombus(double a, double h) {
        super(a);
        this.h = h;
    }

    @Override
    public double getArea() {
        return getA() * h;
    }
}