package oop.abstraction.interfaces;

public abstract class Parallelogram implements Figure{

    private final double a;

    public Parallelogram(double a){
        this.a = a;
    }

    public double getA() {
        return a;
    }

}
