package org.example.oop_exercise_3;

import java.util.List;

import static org.example.oop_exercise_3.Validator.validate;

public class Main {
    public static void main(String[] args) {
        //Example 1: Validate positive numbers
        boolean isPositive = validate(5, num -> num > 0);
        System.out.println("Is 5 positive? " + isPositive);

        //Example 2: Validate non-empty strings
        boolean isNonEmpty = validate("Hello", str -> !str.isEmpty());
        System.out.println("Is 'Hello' non-empty? " + isNonEmpty);

        //Example 3: Validate non-empty collections
        boolean isCollectionsNonEmpty = validate(
                List.of(1, 2, 3),
                list -> !list.isEmpty()
        );
        System.out.println("Is list non-empty? " + isCollectionsNonEmpty);

        //Example 4: Custom criteria: validate even numbers
        boolean isEven = validate(4, num -> num % 2 == 0);
        System.out.println("Is 4 even? " + isEven);

    }
}
