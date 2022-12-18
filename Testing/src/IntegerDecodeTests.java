import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerDecodeTests{
    @Test
    public void testEmpty(){
        assertThrows(NumberFormatException.class, () -> Integer.decode(""));
    }
    @Test
    public void testZeroes(){
        assertEquals(0, Integer.decode("0000000000"));
    }
    @Test
    public void testMinus(){
        assertEquals(-123, Integer.decode("-123"));
    }
    @Test
    public void testPlus(){
        assertEquals(123, Integer.decode("+123"));
    }
    @Test
    public void testStartsWithZero(){
        assertNotEquals(12, Integer.decode("0012"));
    }
    @Test
    void TestOcta(){
        Assertions.assertEquals(19, Integer.decode("023"));
    }
    @Test
    void TestNegativeOcta(){
        Assertions.assertEquals(-10, Integer.decode("-012"));
    }
    @Test
    public void testHex(){
        assertEquals(10, Integer.decode("0xA"));
        assertEquals(-11, Integer.decode("-0xB"));
        assertEquals(10, Integer.decode("#A"));
        assertEquals(-11, Integer.decode("-#B"));
    }
    @Test
    public void testSystems(){
        assertNotEquals(Integer.decode("012"), Integer.decode("12"));
    }
    @Test
    public void testCatchMinValue(){
        assertEquals(Optional.of(Integer.MIN_VALUE), Optional.of(Integer.decode("-2147483648")));
    }
    @Test
    public void testCatchMaxValue(){
        assertEquals(Optional.of(Integer.MIN_VALUE), Optional.of(Integer.decode("-2147483648")));
    }
    @Test
    public void testRandomString() {
        assertThrows(NumberFormatException.class, () -> Integer.decode("Ulululu"));
    }
}