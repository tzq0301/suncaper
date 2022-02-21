package cn.tzq0301.t2;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author tzq0301
 * @version 1.0
 */
class SubTest {

    @Test
    void compute() {
        assertEquals(new BigDecimal(-1), new Sub().compute(new BigDecimal(0), new BigDecimal(1)));
    }
}