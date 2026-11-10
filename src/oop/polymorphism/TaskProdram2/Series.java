package oop.polymorphism.TaskProdram2;

public class Series implements Multiplatform{

    private final double runtime;
    private final String title;
    private final int totalseries;

    public Series(double runtime, String title, int totalseries){
        this.runtime = runtime;
        this.title = title;
        this.totalseries = totalseries;
    }

    @Override
    public double getRuntime(){
        return runtime;
    }

    @Override
    public String getTitle(){
        return title;
    }

    public int getTotalseries(){
        return totalseries;
    }

}
