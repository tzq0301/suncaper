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
        IntStack stack = new IntStack(2);

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
        assertThrows(Exception.class, stack::top);

        assertTrue(stack.push(1));

        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(1, stack.top());

        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
        assertThrows(Exception.class, stack::top);

        assertTrue(stack.push(1));
        assertTrue(stack.push(2));
        assertTrue(stack.push(3));
        assertTrue(stack.push(4));
        assertTrue(stack.push(5));
        assertTrue(stack.push(6));

        assertEquals(6, stack.pop());
        assertEquals(5, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

}