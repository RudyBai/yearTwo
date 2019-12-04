import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {

    private Car carOne = new Car("A", "B", "131-C-456", 20000, 2013);
    private Car carTwo = new Car("C", "D", "12-D-654", 20000, 2012);

    @Test
    void testComparators() {
        assertTrue(carOne.compareTo(carTwo) < 0);
        assertEquals(0, carOne.millageCompare(carTwo));
        assertTrue(carOne.yearCompare(carTwo) > 0);
    }
}