package cn.tzq0301.t3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author tzq0301
 * @version 1.0
 */
class IntStackTest {

    @Test
    void test() {
        IntStack stack = new IntStack();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        assertThrows(Exception.class, stack::top);

        stack.push(1);

        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(1, stack.top());
    }

}