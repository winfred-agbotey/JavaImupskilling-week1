package org.example.concurrency_exercise_3;

public class Counter {
    private int count = 0;
    private final Object lock = new Object();

    public void increment(){
        synchronized (lock){
            count ++;
            System.out.println("Count: " + count + " by " + Thread.currentThread().getName());

        }
    }

    public int getCount(){
        return count;
    }
}
