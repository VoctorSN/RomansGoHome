package edu.badpals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegexRomanNumbers {
    Map<String,String> regularExpresions = new HashMap<>();
    private void initRegexCollection() {
        this.addRegex("grupoSumatorio", "(?<!C)[DM]|(?<!X)[LC](?![DM])|(?<!I)[VX](?![LC])|I(?![VX])");
        this.addRegex("grupoSustractivo", "(C[DM])|(X[LC])|(I[VX])");
    }

    private void addRegex(String grupoSumatorio, String s) {
        regularExpresions.putIfAbsent(grupoSumatorio,s);
    }

    public Map<String, String> getRegularExpresions() {
        return regularExpresions;
    }

    public String getRegex(String grupo){
        return getRegularExpresions().get(grupo);
    }

    public List<String> getAllRegex(){
        this.initRegexCollection();
        return this.getRegularExpresions().values().stream().toList();
    }
}
