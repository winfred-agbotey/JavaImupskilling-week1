package org.example.exception_exercise_1;

import java.io.IOException;

public class ExceptionDemo {
    // 1. Method that throws a checked exception (IOException)
    public static void checkedExceptionMethod() throws IOException {
        throw new IOException("This is a checked exception: IOException occurred.");
    }

    // 2. Method that throws an unchecked exception (IllegalArgumentException)
    public static void uncheckedExceptionMethod() {
        throw new IllegalArgumentException("This is an unchecked exception: Invalid argument.");
    }
}
