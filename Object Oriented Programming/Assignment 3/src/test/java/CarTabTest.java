import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTabTest {

    @Test
    void getMakeField(CarTab carTab) {
        assertSame("", carTab.getMakeField().getText());
    }
}