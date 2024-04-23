package edu.badpals;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegexRomanNumbers {
    final static Map<String,String> regularExpresions = Map.of(
                                                            "grupoSumatorio", "(?<!C)[DM]|(?<!X)[LC](?![DM])|(?<!I)[VX](?![LC])|I(?![VX])",
                                                            "grupoSustractivo", "(C[DM])|(X[LC])|(I[VX])"
                                                                );

    public static Map<String, String> getRegularExpresions() {
        return regularExpresions;
    }

    public static String getRegex(String grupo){
        return getRegularExpresions().get(grupo);
    }

    public static List<String> getAllRegex(){
        return getRegularExpresions().values().stream().sorted().toList();
    }
}
