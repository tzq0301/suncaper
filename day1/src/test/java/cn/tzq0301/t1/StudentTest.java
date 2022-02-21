package cn.tzq0301.t1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author tzq0301
 * @version 1.0
 */
class StudentTest {

    @Test
    void testToString() {
        assertEquals("学生童昭旗学号为2019141460542", new Student("童昭旗", "2019141460542").toString());
    }
}