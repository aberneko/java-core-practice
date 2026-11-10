import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class DiscountCalculatorTest {

    DiscountCalculator discountCalculator = new DiscountCalculator();

    @Test
    public void shouldGiveNoDiscountForValue999() {
        // Подготовка
        int buySum = 998;
        int expectedSum = 999;

        // Исполнение
        int resultSum = discountCalculator.sumAfterDiscount(buySum);

        // Проверка
        TestLibrary.assertEquals(expectedSum, resultSum);

    }

    @Test
    void shouldGiveDiscountForValue1000OrMore() {
        DiscountCalculator calculator = new DiscountCalculator();
        int result = calculator.sumAfterDiscount(1000);

        // 1000 * 0.98 = 980
        assertEquals(980, result);
    }

}
