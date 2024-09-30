package org.Labs;
/*
@author   $Makohon_Roman
@project   $Roman_To_Integer
@class  $444A
@version  1.0.0
@since 25.09.2024 - 13.55
*/
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.Scanner;

public class RomanToInteger {

    private static final Map<Character, Integer> romanMap = new HashMap<>();
    static {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    // Регулярний вираз для перевірки коректного римського числа
    private static final String ROMAN_REGEX = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";


    // Метод для перевірки, чи є рядок Порожній рядок або null
    public static boolean isValidRoman(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        // Перевірка на наявність недопустимих символів (щось окрім IVXLCDM)
        if (!Pattern.matches("[IVXLCDM]+", input)) {
            return false; // Містить недопустимі символи (цифри, літери тощо)
        }

        // Перевірка на некоректні повторення
        if (input.contains("IIII") || input.contains("VV") || input.contains("XXXX") ||
                input.contains("LL") || input.contains("CCCC") || input.contains("DD") ||
                input.contains("MMMM")) {
            return false;
        }

        // Перевірка на некоректні комбінації
        if (input.contains("IL") || input.contains("IC") || input.contains("VX") ||
                input.contains("XD") || input.contains("LC") || input.contains("DM")) {
            return false;
        }

        // Перевірка на порядок символів (наприклад, IVI)
        if (input.contains("IVI") || input.contains("XCX") || input.contains("IXI")) {
            return false;
        }

        // Перевірка на цифри
        if (Pattern.matches(".*[0-9]+.*", input)) {
            return false;
        }

        // Перевірка на спеціальні символи
        if (Pattern.matches(".*[^IVXLCDM].*", input)) {
            return false;
        }

        // Перевірка на букви нижнього регістру
        if (Pattern.matches(".*[a-z]+.*", input)) {
            return false;
        }

        return Pattern.matches(ROMAN_REGEX, input); // Перевірка за регулярним виразом
    }

    /**
     * Метод для конвертації римського числа в ціле
     * @throws IllegalArgumentException Якщо рядок не є коректним римським числом
     */
    public static int romanToInt(String s) {
        if (!isValidRoman(s)) {
            throw new IllegalArgumentException("Неправильне римське число: " + s);
        }

        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int currentValue = romanMap.get(c);

            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            prevValue = currentValue;
        }

        return result;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("Введіть римське число (або 'exit' для виходу): ");
//            String input = scanner.nextLine().toUpperCase();
//
//            if (input.equals("EXIT")) {
//                System.out.println("Вихід з програми.");
//                break;
//            }
//
//            try {
//                int integer = romanToInt(input);
//                System.out.println(input + " -> " + integer);
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }
        String[] examples = {"XII", "IX", "LVIII", "MCMXCIV", "IIII",
                "IC", "VX", "MMMDCCCLXXXVIII", "xii", "X5V", "V#L"};

        for (String roman : examples) {
            try {
                int integer = romanToInt(roman);
                System.out.println(roman + " -> " + integer);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


