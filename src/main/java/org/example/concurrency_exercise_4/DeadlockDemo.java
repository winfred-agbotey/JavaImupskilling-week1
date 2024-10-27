package org.example.concurrency_exercise_4;

public class DeadlockDemo {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            System.out.println("Thread 1: Acquired lock1");

            try {
                // Simulate some work
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            synchronized (lock2) {
                System.out.println("Thread 1: Acquired lock2");
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            System.out.println("Thread 2: Acquired lock2");

            try {
                // Simulate some work
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            synchronized (lock1) {
                System.out.println("Thread 2: Acquired lock1");
            }
        }
    }

    public static void main(String[] args) {
        DeadlockDemo demo = new DeadlockDemo();

        Thread t1 = new Thread(demo::method1);
        Thread t2 = new Thread(demo::method2);

        t1.start();
        t2.start();
    }
}
