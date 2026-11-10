package collectionsframework.taskpracticum.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.IO.*;

public class RandomCoffee {
    public static void main(String[] args) {
        List<Stranger> strangers = new ArrayList<>(List.of(
                new Stranger("Анна", 29),
                new Stranger("Иван", 25),
                new Stranger("Мария", 25),
                new Stranger("Павел", 26),
                new Stranger("Святослав", 27),
                new Stranger("Екатерина", 28)
            ));

    PairGenerator pairGenerator = new PairGenerator();

    List<List<Stranger>> pair = pairGenerator.splitByPairs(strangers);

    print(pair);
        
    }
}

class Stranger {
    private final String name;
    private final int age;

    public Stranger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override 
    public String toString(){
        return " name : " + name + 
                ", age : " + age + " ";
    }

}

class PairGenerator {

    private static final Random rnd = new Random();

    public List<List<Stranger>> splitByPairs(List<Stranger> strangers) {

        List<List<Stranger>> pairs = new ArrayList<>();

        while(!strangers.isEmpty()) {
            List<Stranger> pair = getRandomPair(strangers);
            pairs.add(pair); 
        }

        return pairs;
    }

    private List<Stranger> getRandomPair(List<Stranger> strangers) {
        int pIndex1 = rnd.nextInt(strangers.size());
        int pIndex2 = rnd.nextInt(strangers.size());
        if (pIndex2 == pIndex1) {
            pIndex2 = rnd.nextInt(strangers.size());
        }
        Stranger personOne = strangers.get(pIndex1);
        Stranger personTwo = strangers.get(pIndex2);
        
        strangers.remove(personOne);
        strangers.remove(personTwo);
        return List.of(personOne, personTwo);

    }

}
