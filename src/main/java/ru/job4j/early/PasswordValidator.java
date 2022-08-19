package ru.job4j.early;

import static java.lang.Character.*;

public class PasswordValidator {
    private static final String[] FORBIDDINGS = new String[]{
            "qwerty", "12345", "password", "admin", "user"
    };

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password length must be at least 8 and not more than 32 characters");
        }
        for (String fWord : FORBIDDINGS) {
            if (password.toLowerCase().contains(fWord)) {
                throw new IllegalArgumentException("Password must not contain: " + fWord);
            }
        }
        for (int i = 0; i < password.length(); i++) {
            if (isDigit(password.charAt(i))) {
                break;
            }
            if (i == password.length() - 1) {
                throw new IllegalArgumentException("Password must contain at least one digit");
            }
        }
        for (int i = 0; i < password.length(); i++) {
            if (!isLetterOrDigit(password.charAt(i))) {
                break;
            }
            if (i == password.length() - 1) {
                throw new IllegalArgumentException("Password must contain at least one symbol like : %$#! etc.");
            }
        }
        for (int i = 0; i < password.length(); i++) {
            if (isLowerCase(password.charAt(i))) {
                break;
            }
            if (i == password.length() - 1) {
                throw new IllegalArgumentException("Password must contain at least one char in lower case");
            }
        }
        for (int i = 0; i < password.length(); i++) {
            if (isUpperCase(password.charAt(i))) {
                break;
            }
            if (i == password.length() - 1) {
                throw new IllegalArgumentException("Password must contain at least one char in upper case");
            }
        }
        return password;
    }
}
