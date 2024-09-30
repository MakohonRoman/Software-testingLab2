package org.Labs;/*
@author   $Makohon_Roman
@project   $Roman_To_Integer
@class  $444A
@version  1.0.0
@since 25.09.2024 - 13.55
*/

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RomanToIntegerTest {

    // Тест на перевірку правильності конвертації
    @Test
    public void testRomanToIntegerConversion() {
        assertEquals(1, RomanToInteger.romanToInt("I"));
        assertEquals(2, RomanToInteger.romanToInt("II"));
        assertEquals(3, RomanToInteger.romanToInt("III"));
        assertEquals(4, RomanToInteger.romanToInt("IV"));
        assertEquals(5, RomanToInteger.romanToInt("V"));
        assertEquals(6, RomanToInteger.romanToInt("VI"));
        assertEquals(7, RomanToInteger.romanToInt("VII"));
        assertEquals(8, RomanToInteger.romanToInt("VIII"));
        assertEquals(10, RomanToInteger.romanToInt("X"));
        assertEquals(20, RomanToInteger.romanToInt("XX"));
        assertEquals(30, RomanToInteger.romanToInt("XXX"));
        assertEquals(40, RomanToInteger.romanToInt("XL"));
        assertEquals(50, RomanToInteger.romanToInt("L"));
        assertEquals(90, RomanToInteger.romanToInt("XC"));
        assertEquals(100, RomanToInteger.romanToInt("C"));
        assertEquals(400, RomanToInteger.romanToInt("CD"));
        assertEquals(500, RomanToInteger.romanToInt("D"));
        assertEquals(900, RomanToInteger.romanToInt("CM"));
        assertEquals(1000, RomanToInteger.romanToInt("M"));
        assertEquals(1994, RomanToInteger.romanToInt("MCMXCIV"));
        assertEquals(3888, RomanToInteger.romanToInt("MMMDCCCLXXXVIII"));
    }
}
