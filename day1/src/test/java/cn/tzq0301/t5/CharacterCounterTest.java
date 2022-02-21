package cn.tzq0301.t5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author tzq0301
 * @version 1.0
 */
class CharacterCounterTest {

    @Test
    void count() {
        CharacterCounter.countAndPrint("bcbcabcbcbc");
    }
}