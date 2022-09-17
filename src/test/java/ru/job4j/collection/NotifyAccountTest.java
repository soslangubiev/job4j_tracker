package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NotifyAccountTest {
    @Test
    public void sentShouldReturnSetWhenInputDoesNotContainDuplicates() {
        NotifyAccount notifyAccount = new NotifyAccount();
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(notifyAccount.sent(accounts)).containsAll(expect);
    }

    @Test
    public void sentShouldReturnSetWhenInputContainsDuplicatesByUsername() {
        NotifyAccount notifyAccount = new NotifyAccount();
        Account unique = new Account("123", "Petr Arsentev", "eDer3432f");
        List<Account> accounts = Arrays.asList(
                unique,
                new Account("123", "Petr Arsentev", "fsdf$rews")
        );
        assertThat(notifyAccount.sent(accounts)).containsOnly(unique);
    }

    @Test
    public void sentShouldReturnSetWhenInputContainsDuplicatesByDeposit() {
        NotifyAccount notifyAccount = new NotifyAccount();
        Account unique = new Account("123", "Petr Arsentev", "eDer3432f");
        List<Account> accounts = Arrays.asList(
                unique,
                new Account("123", "Ivan Ivanov", "eDer3432f")
        );
        assertThat(notifyAccount.sent(accounts)).containsOnly(unique);
    }
}