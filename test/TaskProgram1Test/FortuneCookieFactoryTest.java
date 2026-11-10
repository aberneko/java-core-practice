package TaskProgram1Test;
import Practice.TaskProgram1.FortuneConfig;
import Practice.TaskProgram1.FortuneCookieFactory;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FortuneCookieFactoryTest {

    private ArrayList<String> positive;
    private ArrayList<String> negative;
    private FortuneCookieFactory fortuneCookieFactory;

    @BeforeEach
    public  void beforeEach(){
        positive = new ArrayList<>();
        positive.add("Дождь идёт");
        negative = new ArrayList<>();
        negative.add("Дождь прошёл");
        FortuneConfig fortuneConfig = new FortuneConfig(true);
        fortuneCookieFactory = new FortuneCookieFactory(fortuneConfig, positive, negative);
    }

    @Test
    public void shouldIncrementCountByOneAfterOneCookieBaked(){
        fortuneCookieFactory.bakeFortuneCookie();
        assertEquals(1, fortuneCookieFactory.getCookiesBaked());
    }

    @Test
    public void shouldIncrementCountByTwoAfterTwoCookiesBaked(){
        fortuneCookieFactory.bakeFortuneCookie();
        fortuneCookieFactory.bakeFortuneCookie();
        assertEquals(2, fortuneCookieFactory.getCookiesBaked());
    }

    @Test
    public void shouldSetCounterToZeroAfterResetCookieCreatedCall(){
        fortuneCookieFactory.resetCookiesCreated();
        assertEquals(0, fortuneCookieFactory.getCookiesBaked());
    }



}
