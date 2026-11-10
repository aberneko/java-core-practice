package collectionsframework.taskpracticum.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PotatoLaboratory {

    public static void main(String[] args) {
        List<Potato> potatoes = List.of(
                new Potato(1, 30, 30, 30),
                new Potato(2, 35, 31, 35),
                new Potato(3, 40, 35, 44),
                new Potato(4, 28, 44, 41),
                new Potato(5, 33, 23, 30),
                new Potato(6, 35, 33, 33),
                new Potato(7, 38, 41, 24)
        );

        List<Potato> fourUnderExperiment = findPotatoesForExperiment(potatoes);

        System.out.println("Картофелины для эксперимента: " + fourUnderExperiment);
    }

    private static List<Potato> findPotatoesForExperiment(List<Potato> potatoes) {
				/* Вычислите две самые большие и две самые маленькие картофелины,
           а затем выведите их в порядке от самых маленьких до самых больших.*/
        List<Potato> potatoes1 = new ArrayList<>(potatoes);
        Potato oneMinPotato = Collections.min(potatoes1);
        Potato oneBigPotato = Collections.max(potatoes1);

        potatoes1.remove(oneMinPotato);
        potatoes1.remove(oneBigPotato);

        Potato twoMinPotato = Collections.min(potatoes1);
        Potato twoBigPotato = Collections.max(potatoes1);

        List<Potato> potatoes2 = new ArrayList<>(List.of(oneMinPotato, oneBigPotato, twoMinPotato, twoBigPotato));
        Collections.sort(potatoes2);

        return potatoes2;
    }

}
