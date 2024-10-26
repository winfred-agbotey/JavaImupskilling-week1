package org.example.exception_exercise_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadingExample {
    public static void readFile(String filePath) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            System.out.println("Reading from the file:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                    System.out.println("File has been closed.");
                }
            } catch (IOException e) {
                System.out.println("Failed to close the file: " + e.getMessage());
            }
        }

    }
}