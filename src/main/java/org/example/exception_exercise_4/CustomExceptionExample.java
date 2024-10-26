package org.example.exception_exercise_4;

import java.util.Scanner;

public class CustomExceptionExample {

    // Method to validate the age
    public static void validateAge(int age) {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException("Age must be between 0 and 120.");
        } else {
            System.out.println("Valid age: " + age);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        try {
            validateAge(age);  // This may throw InvalidAgeException
        } catch (InvalidAgeException e) {
            System.out.println("Caught InvalidAgeException: " + e.getMessage());
        }

        System.out.println("Program continues after handling the exception.");
    }
}
