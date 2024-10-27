package org.example.concurrency_exercise_1;

public class ImageProcessingThreadPool {
    // Simulate image processing task
    public static void processImage(int imageId) {
        System.out.println("Processing image: " + imageId + " by " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);  // Simulate processing time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // Preserve interrupt status
        }
        System.out.println("Completed image: " + imageId);
    }
}
