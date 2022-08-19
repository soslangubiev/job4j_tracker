package ru.job4j.early;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static ru.job4j.early.PasswordValidator.validate;

class PasswordValidatorTest {
    @Test
    void validateShouldReturnPasswordWhenInputIsValid() {
        String expected = "koTiki5?";
        String actual = validate(expected);
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void validateShouldThrowExceptionWhenInputIsNull() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validate(null))
                .withMessage("Password cannot be null");
    }

    @Test
    void validateShouldThrowExceptionWhenInputLessThan8() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validate("koTiki5"))
                .withMessage("Password length must be at least 8 and not more than 32 characters");
    }

    @Test
    void validateShouldThrowExceptionWhenInputMoreThan32() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validate("koTiki5?koTiki5?koTiki5?koTiki5?k"))
                .withMessage("Password length must be at least 8 and not more than 32 characters");
    }

    @Test
    void validateShouldThrowExceptionWhenInputContainsForbiddenWord() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validate("AdmiNkoTiki5?"))
                .withMessage("Password must not contain: admin");
    }

    @Test
    void validateShouldThrowExceptionWhenInputNotContainsDigit() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validate("koTiki#?"))
                .withMessage("Password must contain at least one digit");
    }

    @Test
    void validateShouldThrowExceptionWhenInputNotContainsSpecialSymbol() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validate("koTiki55"))
                .withMessage("Password must contain at least one symbol like : %$#! etc.");
    }

    @Test
    void validateShouldThrowExceptionWhenInputNotContainsLetterInLowerCase() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validate("KOTIKI5?"))
                .withMessage("Password must contain at least one char in lower case");
    }

    @Test
    void validateShouldThrowExceptionWhenInputNotContainsLetterInUpperCase() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validate("kotiki5?"))
                .withMessage("Password must contain at least one char in upper case");
    }
}