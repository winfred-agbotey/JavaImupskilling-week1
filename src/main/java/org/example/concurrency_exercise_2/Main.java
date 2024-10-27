package org.example.concurrency_exercise_2;

public class Main {
    public static void main(String[] args) {
        InMemoryCache<String, String> cache = new InMemoryCache<>();

        //Simulate multiple threads accessing the cache
        Runnable task1 = () -> cache.put("name", "Mawuli");
        Runnable task2 = () -> cache.put("city", "Tema");

        new Thread(task1).start();
        new Thread(task2).start();

        //Wait briefly to allow cache operations to complete
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Retrieved: " + cache.get("name"));
    }
}
