package org.example.exception_exercise_1;

import java.io.IOException;

import static org.example.exception_exercise_1.ExceptionDemo.checkedExceptionMethod;
import static org.example.exception_exercise_1.ExceptionDemo.uncheckedExceptionMethod;

public class Main {
    public static void main(String[] args) {
        // Handling both checked and unchecked exceptions in try-catch blocks

        // 1. Handling Checked Exception (requires explicit try-catch or throws clause)
        try {
            checkedExceptionMethod();  // This will throw IOException
        } catch (IOException e) {
            System.out.println("Caught checked exception: " + e.getMessage());
        }

        // 2. Handling Unchecked Exception (optional to catch, but good practice)
        try {
            uncheckedExceptionMethod();  // This will throw IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("Caught unchecked exception: " + e.getMessage());
        }

        // Demonstrate normal program flow continues after exception handling
        System.out.println("Program continues after exception handling.");
    }
}
