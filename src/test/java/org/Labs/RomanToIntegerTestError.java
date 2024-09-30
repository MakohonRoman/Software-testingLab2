package org.Labs;

import static org.junit.jupiter.api.Assertions.*;

/*
@author   $Makohon_Roman
@project   $Roman_To_Integer
@class  $444A
@version  1.0.0
@since 25.09.2024 - 13.55
*/
import org.junit.jupiter.api.Test;

public class RomanToIntegerTestError  {

    // 1. Тест на коректні римські числа
    @Test
    public void testValidRomanNumerals() {
        assertEquals(12, RomanToInteger.romanToInt("XII"));
        assertEquals(9, RomanToInteger.romanToInt("IX"));
        assertEquals(58, RomanToInteger.romanToInt("LVIII"));
        assertEquals(1994, RomanToInteger.romanToInt("MCMXCIV"));
        assertEquals(3888, RomanToInteger.romanToInt("MMMDCCCLXXXVIII"));
    }

    // 2. Тест на порожній рядок та null
    @Test
    public void testEmptyOrNull() {
        assertThrows(IllegalArgumentException.class, () -> RomanToInteger.romanToInt(null));
        assertThrows(IllegalArgumentException.class, () -> RomanToInteger.romanToInt(""));
    }

    // 3. Тест на занадто багато повторень
    @Test
    public void testInvalidRepeats() {
        assertThrows(IllegalArgumentException.class, () -> RomanToInteger.romanToInt("IIII"));
        assertThrows(IllegalArgumentException.class, () -> RomanToInteger.romanToInt("VV"));
        assertThrows(IllegalArgumentException.class, () -> RomanToInteger.romanToInt("XXXX"));
        assertThrows(IllegalArgumentException.class, () -> RomanToInteger.romanToInt("CCCC"));
        assertThrows(IllegalArgumentException.class, () -> RomanToInteger.romanToInt("MMMM"));
    }

    // 4. Тест на некоректні комбінації символів
    @Test
    public void testInvalidCombinations() {
        assertThrows(IllegalArgumentException.class, () -> RomanToInteger.romanToInt("IC"));
        assertThrows(IllegalArgumentException.class, () -> RomanToInteger.romanToInt("VX"));
        assertThrows(IllegalArgumentException.class, () -> RomanToInteger.romanToInt("IL"));
        assertThrows(IllegalArgumentException.class, () -> RomanToInteger.romanToInt("XD"));
        assertThrows(IllegalArgumentException.class, () -> RomanToInteger.romanToInt("LC"));
    }

    // 5. Тест на цифри у рядку
    @Test
    public void testInvalidNumerals() {
        assertThrows(IllegalArgumentException.class, () -> RomanToInteger.romanToInt("X5V"));
    }

    // 6. Тест на спеціальні символи
    @Test
    public void testInvalidSpecialCharacters() {
        assertThrows(IllegalArgumentException.class, () -> RomanToInteger.romanToInt("V#L"));
        assertThrows(IllegalArgumentException.class, () -> RomanToInteger.romanToInt("M@X"));
    }

    // 7. Тест на малі літери
    @Test
    public void testLowerCaseLetters() {
        assertThrows(IllegalArgumentException.class, () -> RomanToInteger.romanToInt("xii"));
    }

    // 8. Тест на змішані регістри (малі і великі літери)
    @Test
    public void testMixedCaseLetters() {
        assertThrows(IllegalArgumentException.class, () -> RomanToInteger.romanToInt("XxI"));
    }

    // 9. Тест на неправильний порядок символів
    @Test
    public void testInvalidOrder() {
        assertThrows(IllegalArgumentException.class, () -> RomanToInteger.romanToInt("IVI"));
        assertThrows(IllegalArgumentException.class, () -> RomanToInteger.romanToInt("XCX"));
    }

    // 10. Тест на довжину рядка (якщо римське число занадто довге)
    @Test
    public void testTooLongRomanNumeral() {
        assertThrows(IllegalArgumentException.class, () -> RomanToInteger.romanToInt("MMMMMMMMMM"));
    }

    // 11. Тест на пробіли
    @Test
    public void testSpacesInInput() {
        assertThrows(IllegalArgumentException.class, () -> RomanToInteger.romanToInt("X II"));
        assertThrows(IllegalArgumentException.class, () -> RomanToInteger.romanToInt(" IX "));
    }
}
