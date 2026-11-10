///
package collectionsframework.taskpracticum.comparable;

import java.util.Objects;

public class Potato implements Comparable<Potato>{

    public final int id;

    /**
     * Масса
     */
    public final int weight;

    /**
     * Длина
     */
    public final int length;

    /**
     * Ширина
     */
    public final int girth;

    public final double alfha;


    public Potato(int id, int weight, int length, int girth) {
        this.id = id;
        this.weight = weight;
        this.length = length;
        this.girth = girth;

        this.alfha = (weight * 0.5) + (length * 0.65) + (girth * 0.8);
    }


    @Override
    public int compareTo(Potato o) {
        return Double.compare(this.alfha, o.alfha);
        // Сравните картофелины по альфа характеристике
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Potato potato = (Potato) o;
        return id == potato.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Potato{" +
                "id=" + id +
                ", weight=" + weight +
                ", length=" + length +
                ", girth=" + girth +
                '}';
    }

}
