package edu.badpals;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumber {

    private final String number;
    private short decimal = 0;
    private static final Map<String,Integer> LETTERS = new LinkedHashMap<>();

    static {
        LETTERS.put("M",1000);
        LETTERS.put("DM",900);
        LETTERS.put("D",500);
        LETTERS.put("CD",400);
        LETTERS.put("C",100);
        LETTERS.put("XC",90);
        LETTERS.put("L",50);
        LETTERS.put("XL",40);
        LETTERS.put("X",10);
        LETTERS.put("IX",9);
        LETTERS.put("V",5);
        LETTERS.put("IV",4);
        LETTERS.put("I",1);
    }

    public RomanNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public short toDecimal() {
         if (RegexRomanNumbers.validate(this.number)){
             this.calculateDecimal();
             return this.decimal;
         }
         return (short) 0;
    }

    @Override
    public String toString() {
        return getNumber();
    }

    public String getRegexCollection() {
        return RegexRomanNumbers.getDecimalRegex();
    }

    public RomanNumber Suma(RomanNumber romanNumber){
        int suma = romanNumber.toDecimal() + this.toDecimal();
        return new RomanNumber(RomanNumber.toRoman(suma));
    }

    public static String toRoman(int number) {
        StringBuilder resoult = new StringBuilder();
        for(Map.Entry<String,Integer> entry : LETTERS.entrySet()){
            while (number >= entry.getValue()){
                number -= entry.getValue();
                resoult.append(entry.getKey());
            }
        }
        return resoult.toString();
    }

    private void calculateDecimal() {
        updateMatches(Pattern.compile(RegexRomanNumbers.getDecimalRegex()).matcher(this.number));
    }

    private void updateMatches(Matcher matcher) {
        while (matcher.find()) {
            this.decimal += decimalValue(matcher.group());
        }
    }

    private short decimalValue(String romanNumber) {
        return (short) RomanSymbols.valueOf(romanNumber).getDecimalValue();
    }
}
