package datatypes;

public class CalorieCalculator {
    public static void main(String[] args) {
        String pixelKcalDay = "43";
        String beefKcal = "30.2";
        String chickenKcal = "23.8";
        String creamKcal = "32.1";
        String milkKcal = "13.5";

        float pixelChoice = getMinKcalsSum(beefKcal, chickenKcal, creamKcal, milkKcal);
        float totalKcal = Float.parseFloat(pixelKcalDay) + pixelChoice;
        checkKcal(totalKcal);
    }

    private static Float getMinKcalsSum(String firstDishKcal, String secondDishKcal, String firstDesert, String secondDesert) {
        float minDishKcal = Float.min(Float.parseFloat(firstDishKcal), Float.parseFloat(secondDishKcal)); // вычислите минимальную калорийность основного блюда
        float minDesertKcal = Float.max(Float.parseFloat(firstDesert), Float.parseFloat(secondDesert)); // вычислите минимальную калорийность десерта
        return minDishKcal + minDesertKcal;
    }

    private static void checkKcal(Float catKcal) {
        if (catKcal == null) {
            System.out.println("Что-то пошло не так");
        } else {
            System.out.println("Калорийность рациона Пикселя за день: " + catKcal);
            if (catKcal > 100) {
                System.out.println("Пиксель сегодня не уложился в норму.");
            } else {
                System.out.println("Лимит не превышен!");
            }
        }
    }
}
