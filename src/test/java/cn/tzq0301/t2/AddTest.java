package cn.tzq0301.t2;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author tzq0301
 * @version 1.0
 */
class AddTest {

    @Test
    void compute() {
        assertEquals(new BigDecimal(1), new Add().compute(new BigDecimal(0), new BigDecimal(1)));
    }
}