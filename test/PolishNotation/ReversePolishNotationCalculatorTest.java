package PolishNotation;

import java.util.ArrayDeque;
import java.util.Deque;

import Practice.PolishNotation.ReversePolishNotationCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReversePolishNotationCalculatorTest {

    private final ReversePolishNotationCalculator rpn = new ReversePolishNotationCalculator();

    @Test
    public void shouldCalculateSubtraction() {
        String str = "3 1 -";
        assertEquals(2, rpn.calculatePolishNotation(str));
    }

    @Test
    public void shouldCalculateSubtractionNegativeVariable() {
        String str = "-1 3 -";
        assertEquals(-4, rpn.calculatePolishNotation(str));
    }

    @Test
    public void shouldCalculateSubtractionNegativeResult() {
        String str = "1 3 -";
        assertEquals(-2, rpn.calculatePolishNotation(str));
    }

    @Test
    public void shouldCalculateAddition() {
        String str = "3 1 +";
        assertEquals(4, rpn.calculatePolishNotation(str));
    }

    @Test
    public void shouldCalculateMultiplication() {
        String str = "3 1 *";
        assertEquals(3, rpn.calculatePolishNotation(str));
    }

    @Test
    public void shouldCalculateAdditionWithExtraSpaces() {
        String str = "3       1     +";
        assertEquals(4, rpn.calculatePolishNotation(str));
    }




}

