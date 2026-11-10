import junittest.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;

public class ItemTest {

    @Test
    public void itemsShouldBeEqualByFields(){
        Item item1 = new Item("Яблоки", 50);
        Item item2 = new Item("Груши", 50);

        assertEquals(item1, item2);
    }

//    public static class ArrayTest{
//
//        @Test
//        public void arraysShouldMatch(){
//            String[] expectedArray = {"hello", "world"};
//            String[] actualArray = {"hello", "world"};
//
//            // assertArrayEquals поэлементно проверяет содержимое и порядок
//            assertArrayEquals(expectedArray, actualArray, "Массивы должны быть одинаковыми!");
//        }
//    }
}
