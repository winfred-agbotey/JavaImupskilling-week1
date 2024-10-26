package org.example.exception_exercise_2;

public class Main {
    public static void main(String[] args) {
        try {
            // Outer try block: Array access
            int[] numbers = {1, 2, 3};
            System.out.println("Accessing array element: " + numbers[3]);  // Throws ArrayIndexOutOfBoundsException

            try {
                // Inner try block: Division operation
                int result = divide(10, 0);  // Throws ArithmeticException
                System.out.println("Division result: " + result);

                try {
                    // Innermost try block: Null reference
                    String text = null;
                    System.out.println("String length: " + text.length());  // Throws NullPointerException
                } catch (NullPointerException e) {
                    System.out.println("Caught NullPointerException: " + e.getMessage());
                }

            } catch (ArithmeticException e) {
                System.out.println("Caught ArithmeticException: Division by zero.");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        System.out.println("Program continues after handling exceptions.");
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}
