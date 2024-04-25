package edu.badpals;

import java.util.regex.Pattern;

public class RegexRomanNumbers {

    static final String decimalRegex = "(?<!C)[DM]|(?<!X)[LC](?![DM])|(?<!I)[VX](?![LC])|I(?![VX])|(C[DM])|(X[LC])|(I[VX])";
    static final String validatorRegex = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";


    public static String getDecimalRegex() {
        return decimalRegex;
    }

    public static String getValidatorRegex() {
        return validatorRegex;
    }

    static boolean validate(String number){
        return Pattern.compile(RegexRomanNumbers.getValidatorRegex()).matcher(number).matches();
    }
}
