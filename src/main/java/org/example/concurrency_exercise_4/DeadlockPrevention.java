package org.example.concurrency_exercise_4;

public class DeadlockPrevention {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            System.out.println("Thread 1: Acquired lock1");

            synchronized (lock2) {
                System.out.println("Thread 1: Acquired lock2");
            }
        }
    }

    public void method2() {
        synchronized (lock1) {  // Use consistent lock order
            System.out.println("Thread 2: Acquired lock1");

            synchronized (lock2) {
                System.out.println("Thread 2: Acquired lock2");
            }
        }
    }

    public static void main(String[] args) {
        DeadlockPrevention demo = new DeadlockPrevention();

        Thread t1 = new Thread(demo::method1);
        Thread t2 = new Thread(demo::method2);

        t1.start();
        t2.start();
    }
}
