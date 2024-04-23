package edu.badpals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumber {

    private final String number;
    private short decimal = 0;
    private RegexRomanNumbers regexRomanNumbers = new RegexRomanNumbers();

    RomanNumber(String number){
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public short toDecimal() {
        this.calculateDecimal();
        return this.decimal;
    }

    private void calculateDecimal() {
        for (String regularExpresion : regexRomanNumbers.getAllRegex()){
            Matcher matcher = Pattern.compile(regularExpresion).matcher(this.number);
            updateMatches(matcher);
        }
    }

    private void updateMatches(Matcher matcher) {
        while(matcher.find()){
            this.decimal += decimalValue(matcher.group());
        }
    }

    public short decimalValue(String romanNumber){
        return (short) RomanSymbols.valueOf(romanNumber).getDecimalValue();
    }

    @Override
    public String toString() {
        return getNumber();
    }

    public RegexRomanNumbers getRegexCollection() {
        return regexRomanNumbers;
    }
}
