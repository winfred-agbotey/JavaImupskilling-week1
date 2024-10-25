package org.example.oop_exercise_3;

import java.util.function.Predicate;

public class Validator {
    public static <T> boolean validate(T value, Predicate<T> criteria) {
        return criteria.test(value);

    }
}
