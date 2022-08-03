package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] result = new Item[size];
        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                result[i] = items[i];
            }
        }
        return Arrays.copyOf(result, size);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        int length = 0;
        for (Item item : items) {
            if (item != null && key.equals(item.getName())) {
                result[length] = item;
                length++;
            }
        }
        return Arrays.copyOf(result, length);
    }
}