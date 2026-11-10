package oop.polymorphism.TaskProdram2;

import java.util.List;

public class Calculator {
    public Calculator (){

    }

    public static double calculate(List<Multiplatform> multi){
        double totalDays = 0;
        for (Multiplatform mul : multi){
             if (mul instanceof Series series) { // Series series = (Series) mul;
                 totalDays += series.getTotalseries() * mul.getRuntime();
             } else {
                 totalDays += mul.getRuntime();
             }
        }

        return totalDays / 24*60;
    }
}
