package edu.badpals;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;

public class RegexRomanNumbers {
    static final Map<String, String> regularExpresions = Map.of(
            "grupoSumatorio", "(?<!C)[DM]|(?<!X)[LC](?![DM])|(?<!I)[VX](?![LC])|I(?![VX])",
            "grupoSustractivo", "(C[DM])|(X[LC])|(I[VX])"
    );

    public static Map<String, String> getRegularExpresions() {
        return regularExpresions;
    }

    public static String getRegex(String grupo) {
        return getRegularExpresions().get(grupo);
    }

    public static List<String> getAllRegex() {
        return getRegularExpresions().values().stream().sorted().toList();
    }

}
