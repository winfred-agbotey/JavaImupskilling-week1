package org.example.oop_exercise_5;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        InMemoryCache<String, String> cache = new InMemoryCache<>();

        //Thread 1: Adding values to the cache

        Thread writeThread = new Thread(() -> {
            cache.put("1", "one");
            cache.put("2", "two");
            cache.put("3", "three");
            System.out.println("Write Thread: Values added to cache");
        });

        //Thread 2: Reading values from the cache
        Thread readerThread = new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println("Reader Thread: Value for key 1: " + cache.get("1"));
                System.out.println("Reader Thread: Value for key 2: " + cache.get("2"));
                System.out.println("Reader Thread: Value for key 3: " + cache.get("3"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        writeThread.start();
        readerThread.start();

        writeThread.join();
        readerThread.join();

        System.out.println("Cache size after operations: " + cache.size());
    }
}
