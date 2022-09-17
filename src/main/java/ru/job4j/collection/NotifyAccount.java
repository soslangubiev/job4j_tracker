package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class NotifyAccount {
    public HashSet<Account> sent(List<Account> accounts) {
        return new HashSet<>(accounts);
    }
}
