package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class FactTest {
    @Test
    void whenInputIs5Then120() {
        Fact fact = new Fact();
        int expected = 120;
        int actual = fact.calc(5);
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void whenInputIsNegativeThenException() {
        Fact fact = new Fact();
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> fact.calc(-5))
                .withMessage("N could not be less than 0");
    }
}