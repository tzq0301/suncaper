package cn.tzq0301.t2;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author tzq0301
 * @version 1.0
 */
class MulTest {

    @Test
    void compute() {
        assertEquals(new BigDecimal(0), new Mul().compute(new BigDecimal(0), new BigDecimal(1)));
        assertEquals(new BigDecimal(2), new Mul().compute(new BigDecimal(2), new BigDecimal(1)));
    }
}