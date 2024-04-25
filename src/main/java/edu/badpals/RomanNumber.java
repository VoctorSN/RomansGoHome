package edu.badpals;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumber {

    private final String number;
    private final Integer decimal;
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
        this.decimal = toDecimal();
    }

    public RomanNumber(Integer decimal) {
        this.decimal = decimal;
        this.number = this.getRoman();
    }

    public String getNumber() {
        return number;
    }

    public Integer toDecimal() {
         if (RegexRomanNumbers.validate(this.number)){
             return calculateDecimal();
         }
         return 0;
    }

    @Override
    public String toString() {
        return getNumber();
    }

    public String getRegexCollection() {
        return RegexRomanNumbers.getDecimalRegex();
    }

    public RomanNumber suma(RomanNumber romanNumber){
        return new RomanNumber(RomanNumber.toRoman(romanNumber.toDecimal() + this.toDecimal()));
    }

    public static RomanNumber suma(RomanNumber n1, RomanNumber n2){
        return new RomanNumber(RomanNumber.toRoman(n1.toDecimal() + n2.toDecimal()));
    }

    public static String toRoman(int number) {
        StringBuilder resoult = new StringBuilder();
        for(Map.Entry<String,Integer> entry : LETTERS.entrySet()){
            for (; number >= entry.getValue() ; number -= entry.getValue()){
                resoult.append(entry.getKey());
            }
        }
        return resoult.toString();
    }

    private String getRoman() {
        return toRoman(this.decimal);
    }

    private int calculateDecimal() {
        return updateMatches(Pattern.compile(RegexRomanNumbers.getDecimalRegex()).matcher(this.number));
    }

    private int updateMatches(Matcher matcher) {
        int decimal = 0;
        while (matcher.find()) {
            decimal += decimalValue(matcher.group());
        }
        return decimal;
    }

    private Integer decimalValue(String romanNumber) {
        return RomanSymbols.valueOf(romanNumber).getDecimalValue();
    }
}
