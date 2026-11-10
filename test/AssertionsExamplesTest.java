
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsExamplesTest {

    @Test
    public void testNullabilityAndBooleans(){
        String token = null;
        String username = "Женя";
        boolean isTest1 = true;
        boolean istest2 = false;

        assertNull(token);
        assertNotNull(username);

        assertTrue(isTest1);
        assertFalse(istest2);
    }

}
