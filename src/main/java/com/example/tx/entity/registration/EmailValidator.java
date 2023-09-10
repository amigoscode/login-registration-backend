package com.example.tx.entity.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Pattern;

@Service
public class EmailValidator  {
    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@(.+)$"; // Common email regex pattern

    public boolean test(String email) {
        // Use the Pattern class to compile the regular expression
        Pattern pattern = Pattern.compile(EMAIL_REGEX);

        // Use Matcher to match the given email against the pattern
        return pattern.matcher(email).matches();
    }
}
