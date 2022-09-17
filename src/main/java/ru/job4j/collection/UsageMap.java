package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("123@yandex.ru", "Ivan Ivanov");
        map.put("555@gmail.com", "Igor Petrov");
        map.put("777@mail.ru", "Semen Sidorov");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
