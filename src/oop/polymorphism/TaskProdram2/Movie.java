package oop.polymorphism.TaskProdram2;

public class Movie implements Multiplatform{

    private final double runtime;
    private final String title;

    public Movie(double runtime, String title){
        this.runtime = runtime;
        this.title = title;
    }

    @Override
    public double getRuntime(){
        return runtime;
    }

    @Override
    public String getTitle(){
        return title;
    }



}
