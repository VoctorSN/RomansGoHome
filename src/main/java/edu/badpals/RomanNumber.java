package edu.badpals;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumber {

    private final String number;
    private Integer decimal;
    private RegexRomanNumbers regexRomanNumbers = new RegexRomanNumbers();

    RomanNumber(String number){
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public Integer toDecimal() {
        this.calculateDecimal();
        return this.decimal;
    }

    private void calculateDecimal() {
        for (String regularExpresion : regexRomanNumbers.getAllExpresions()){
            Matcher matcher = Pattern.compile(regularExpresion).matcher(this.number);
            updateMatches(matcher)
        }
    }

    private void updateMatches(Matcher matcher) {

    }


}
