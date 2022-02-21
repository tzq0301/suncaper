package cn.tzq0301.t2;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author tzq0301
 * @version 1.0
 */
class DivTest {

    @Test
    void compute() {
        assertEquals(new BigDecimal("-1.5"), new Div().compute(new BigDecimal(-3), new BigDecimal(2)));
        assertThrows(IllegalArgumentException.class, () -> new Div().compute(new BigDecimal(-3), new BigDecimal(0)));
    }
}