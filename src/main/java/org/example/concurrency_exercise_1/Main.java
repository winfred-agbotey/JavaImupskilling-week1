package org.example.concurrency_exercise_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.example.concurrency_exercise_1.ImageProcessingThreadPool.processImage;

public class Main {
    public static void main(String[] args) {
        int numImages = 5;  // Number of images to process
        try (ExecutorService executor = Executors.newFixedThreadPool(3)) {

            for (int i = 1; i <= numImages; i++) {
                int imageId = i;
                executor.submit(() -> processImage(imageId));
            }

            executor.shutdown();  // Prevent new tasks from being submitted
        }  // Thread pool with 3 threads
    }
}
