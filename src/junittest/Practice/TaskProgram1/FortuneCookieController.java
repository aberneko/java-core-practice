package junittest.Practice.TaskProgram1;

import java.util.ArrayList;

public class FortuneCookieController {

    private final FortuneCookieFactory fortuneCookieFactory;

    public FortuneCookieController (FortuneCookieFactory fortuneCookieFactory) {
        this.fortuneCookieFactory = fortuneCookieFactory;
    }

    public FortuneCookie tellFortune() {
        return this.fortuneCookieFactory.bakeFortuneCookie();
    }

    static void main() {
        FortuneConfig fortuneConfig = new FortuneConfig(true);

        ArrayList<String> positive = new ArrayList<>();
        positive.add("Дождь идёт");
        ArrayList<String> negative = new ArrayList<>();
        negative.add("Дождь прошёл");
        FortuneCookieFactory fortuneCookieFactory1 = new FortuneCookieFactory(fortuneConfig, positive, negative);

        FortuneCookieController fortuneCookieController = new FortuneCookieController(fortuneCookieFactory1);
        System.out.print(fortuneCookieController.tellFortune().getFortuneText());
    }
}