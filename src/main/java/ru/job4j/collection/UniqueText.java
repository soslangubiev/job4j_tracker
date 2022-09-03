package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public  boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] duplicate = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String word : origin) {
            check.add(word);
        }
        for (String dWord : duplicate) {
            if (!check.contains(dWord)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
