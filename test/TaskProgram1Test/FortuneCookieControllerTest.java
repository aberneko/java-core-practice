package TaskProgram1Test;
import Practice.TaskProgram1.FortuneConfig;
import Practice.TaskProgram1.FortuneCookieController;
import Practice.TaskProgram1.FortuneCookieFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FortuneCookieControllerTest {

    private ArrayList<String> positive;
    private ArrayList<String> negative;

    @BeforeEach
    public void beforeEach(){
        positive = new ArrayList<>();
        positive.add("Дождь идёт");
        negative = new ArrayList<>();
        negative.add("Дождь прошёл");
    }

    private FortuneCookieController helperBeforeEach(boolean isPositive){
        FortuneConfig fortuneConfig = new FortuneConfig(isPositive);
        FortuneCookieFactory fortuneCookieFactory1 = new FortuneCookieFactory(fortuneConfig, positive, negative);
        return new FortuneCookieController(fortuneCookieFactory1);
    }

    @Test
    public void shouldReturnPositiveFortune(){
        FortuneCookieController fortuneCookieController = helperBeforeEach(true);
        assertEquals("Дождь идёт", fortuneCookieController.tellFortune().getFortuneText());
    }

    @Test
    public void shouldReturnNegativeFortune(){
        FortuneCookieController fortuneCookieController = helperBeforeEach(false);
        assertEquals("Дождь прошёл", fortuneCookieController.tellFortune().getFortuneText());
    }


    //Вариант 2. Параметризованный тест
    @ParameterizedTest
    @CsvSource({
            "true, Дождь идёт",
            "false, Дождь прошёл"
    })
    public void shouldReturnCorrectFortuneBasedOnConfig(boolean isPositive, String expectedText) {
        FortuneConfig config = new FortuneConfig(isPositive);
        FortuneCookieFactory factory = new FortuneCookieFactory(config, positive, negative);
        FortuneCookieController controller = new FortuneCookieController(factory);

        assertEquals(expectedText, controller.tellFortune().getFortuneText());
    }

}
