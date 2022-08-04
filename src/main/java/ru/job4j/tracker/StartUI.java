package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        System.out.println(item.getCreated());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(dateTimeFormatter.format(item.getCreated()));
        Item item2 = new Item();
        System.out.println(item2);
    }
}