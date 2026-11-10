package junittest;

public class TestLibrary {
    public static <T> void assertEquals(T expected, T actual){
        if(!expected.equals(actual)) {
            System.out.printf("Первый элемент %s не равен второму элементу %s", expected, actual);
        }
    }
}
