package TaskProgram2Test;

import junittest.Practice.TaskProgram2.PriceCalculator;
import junittest.Practice.TaskProgram2.TransportType;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PriceCalculatorTest {

    private final PriceCalculator priceCalculator = new PriceCalculator();


    // BIKE
    // точка перед границей -1
        @Test
        public void shouldBeNegativeWhenBikeAndDistanceIsMinus1Km() {
            assertTrue(priceCalculator.calculatePrice(TransportType.BIKE, -1) < 0);
        }

        // Граничное значение 0
        @Test
        public void shouldBeNegativeWhenBikeAndDistanceIs0Km() {
            assertTrue(priceCalculator.calculatePrice(TransportType.BIKE, 0) < 0);
        }
        @Test
        public void shouldReturnMinusOneWhenBikeAndDistanceIs0Km() {
            assertEquals(-1, priceCalculator.calculatePrice(TransportType.BIKE, 0));
        }

        // точка за границей 1
        @Test
        public void shouldBePositiveWhenBikeAndDistanceIs1Km() {
            assertFalse(priceCalculator.calculatePrice(TransportType.BIKE, 1) < 0);
        }

    // точка перед границей 19
    @Test
    public void shouldBePositiveWhenBikeAndDistanceIs19Km() {
        assertFalse(priceCalculator.calculatePrice(TransportType.BIKE, 19) < 0);
    }

    // Граничное значение 20
    @Test
    public void shouldBePositiveWhenBikeAndDistanceIs20Km() {
        assertFalse(priceCalculator.calculatePrice(TransportType.BIKE, 20) < 0);
    }

    @Test
    public void shouldReturnMinusTwoWhenBikeAndDistanceIs21Km() {
        assertEquals(-2, priceCalculator.calculatePrice(TransportType.BIKE, 21));
    }

    @Test
    public void shouldCalculateCorrectPriceWhenBikeAndDistanceIs10Km() {
        assertEquals(100, priceCalculator.calculatePrice(TransportType.BIKE, 10));
    }





    // CAR
    // точка перед границей -1
        @Test
        public void shouldBeNegativeWhenCarAndDistanceIsMinus1Km() {
            assertTrue(priceCalculator.calculatePrice(TransportType.CAR, -1) < 0);
        }

        // Граничное значение 0
        @Test
        public void shouldBeNegativeWhenCarAndDistanceIs0Km() {
            assertTrue(priceCalculator.calculatePrice(TransportType.CAR, 0) < 0);
        }
        @Test
        public void shouldReturnMinusOneWhenCarAndDistanceIs0Km() {
            assertEquals(-1, priceCalculator.calculatePrice(TransportType.CAR, 0));
        }

        // точка за границей 1
        @Test
        public void shouldBePositiveWhenCarAndDistanceIs1Km() {
            assertFalse(priceCalculator.calculatePrice(TransportType.CAR, 1) < 0);
        }

    // точка перед границей 999
    @Test
    public void shouldBePositiveWhenCarAndDistanceIs999Km() {
        assertFalse(priceCalculator.calculatePrice(TransportType.CAR, 999) < 0);
    }

    // Граничное значение 1000
    @Test
    public void shouldBePositiveWhenCarAndDistanceIs1000Km() {
        assertFalse(priceCalculator.calculatePrice(TransportType.CAR, 1000) < 0);
    }

    @Test
    public void shouldReturnMinusTwoWhenCarAndDistanceIs1001Km() {
        assertEquals(-2, priceCalculator.calculatePrice(TransportType.CAR, 1001));
    }

    @Test
    public void shouldCalculateCorrectPriceWhenCarAndDistanceIs10Km() {
        assertEquals(70, priceCalculator.calculatePrice(TransportType.CAR, 10));
    }


    // TRUCK
    // точка перед границей -1
        @Test
        public void shouldBeNegativeWhenTruckAndDistanceIsMinus1Km() {
            assertTrue(priceCalculator.calculatePrice(TransportType.TRUCK, -1) < 0);
        }

        // Граничное значение 0
        @Test
        public void shouldBeNegativeWhenTruckAndDistanceIs0Km() {
            assertTrue(priceCalculator.calculatePrice(TransportType.TRUCK, 0) < 0);
        }
        @Test
        public void shouldReturnMinusOneWhenTruckAndDistanceIs0Km() {
            assertEquals(-1, priceCalculator.calculatePrice(TransportType.TRUCK, 0));
        }

        // точка за границей 1
        @Test
        public void shouldBePositiveWhenTruckAndDistanceIs1Km() {
            assertFalse(priceCalculator.calculatePrice(TransportType.TRUCK, 1) < 0);
        }

    @Test
    public void shouldCalculateCorrectPriceWhenTruckAndDistanceIs10Km() {
        assertEquals(50, priceCalculator.calculatePrice(TransportType.TRUCK, 10));
    }


    //DRONE
    @Test
    public void shouldBeNullWhenDrone() {
        assertNull(priceCalculator.calculatePrice(TransportType.DRONE, 0));
    }










}