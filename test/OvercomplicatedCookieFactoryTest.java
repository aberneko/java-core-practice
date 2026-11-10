import junittest.Practice.OvercomplicatedCookieFactory;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class OvercomplicatedCookieFactoryTest {

    private  OvercomplicatedCookieFactory cookieFactory;
//    private // инкапсуляция от других тестовых классов
//    final // защита от null
//    static // переменная создаться один раз для всего класса, и вызовет баг для 2 теста
//    ArrayList<String> positiveTexts = new ArrayList<>();
//    private final static ArrayList<String> negativeTexts = new ArrayList<>();
//
//    private final static OvercomplicatedCookieFactory overcomplicatedCookieFactory = new OvercomplicatedCookieFactory(
//            positiveTexts,
//            negativeTexts,
//            true
//    );

    @BeforeEach // создание этого перед выполнением каждого теста заново
    public void beforeEach() {
        ArrayList<String> positiveTexts = new ArrayList<>();
        positiveTexts.add("Дождь будет!");

        ArrayList<String> negativeTexts = new ArrayList<>();
        negativeTexts.add("Сегодня будет дождь");

        cookieFactory = new OvercomplicatedCookieFactory(
                positiveTexts,
                negativeTexts,
                true
        );
    }

    @AfterAll           // после каждого теста
    static void afterAll() {
        System.out.println("Running afterAll");
    }


    @Test
    public void shouldReturnPositiveCookie() {
        String cookieText = cookieFactory.bakeFortuneCookie();
        Assertions.assertEquals("Дождь будет!", cookieText);
    }

    @Test
    public void shouldIncreaseCounterByOneAfterCookieBaked(){
        cookieFactory.bakeFortuneCookie();
        Assertions.assertEquals(1, cookieFactory.getCookiesCreated());
    }


}
