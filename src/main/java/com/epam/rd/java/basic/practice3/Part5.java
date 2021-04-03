package com.epam.rd.java.basic.practice3;

public class Part5 {
    protected static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
   protected static final String[] ROMAN_LITERALS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println((i + " --> " + decimal2Roman(i) + " --> " + roman2Decimal(decimal2Roman(i))));
        }
    }

    public static String decimal2Roman(int dec) {

        int i = getFloorIndex(dec);

        if (dec == VALUES[i]) {
            return ROMAN_LITERALS[i];
        }
        return ROMAN_LITERALS[i] + decimal2Roman(dec - VALUES[i]);
    }

    private static int getFloorIndex(int number) {
        for (int i = 0; i < VALUES.length; i++) {
            if (number >= VALUES[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int roman2Decimal(String roman) {

            return (int) evaluateNextRomanNumeral(roman, roman.length() - 1, 0);
        }
        private static double evaluateNextRomanNumeral(String roman, int pos, double rightNumeral) {
            if (pos < 0) return 0;
            char ch = roman.charAt(pos);
            double value = Math.floor(Math.pow(10, "IXCM".indexOf(ch))) + 5 * Math.floor(Math.pow(10, "VLD".indexOf(ch)));
            return value * Math.signum(value + 0.5 - rightNumeral) + evaluateNextRomanNumeral(roman, pos - 1, value);
        }
}
