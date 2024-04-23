package edu.badpals;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumber {

    private final String number;
    private short decimal = 0;

    public RomanNumber(String number) {
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
        for (String regularExpresion : RegexRomanNumbers.getAllRegex()) {
            updateMatches(Pattern.compile(regularExpresion).matcher(this.number));
        }
    }

    private void updateMatches(Matcher matcher) {
        while (matcher.find()) {
            this.decimal += decimalValue(matcher.group());
        }
    }

    private short decimalValue(String romanNumber) {
        return (short) RomanSymbols.valueOf(romanNumber).getDecimalValue();
    }

    @Override
    public String toString() {
        return getNumber();
    }

    public List<String> getRegexCollection() {
        return RegexRomanNumbers.getAllRegex();
    }
}
