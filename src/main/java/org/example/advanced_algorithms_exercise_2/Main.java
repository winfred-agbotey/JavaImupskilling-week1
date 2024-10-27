package org.example.advanced_algorithms_exercise_2;

public class Main {
    public static void main(String[] args) {
        MinHeap taskHeap = new MinHeap(10);

        // Insert tasks with varying priorities
        taskHeap.insert(new Task("Task A", 3));
        taskHeap.insert(new Task("Task B", 1));  // Highest priority
        taskHeap.insert(new Task("Task C", 5));
        taskHeap.insert(new Task("Task D", 2));


        System.out.println("Tasks in the MinHeap:");
        while (!taskHeap.isEmpty()) {
            Task task = taskHeap.extractMin();  // Execute task with highest priority
            System.out.println("Executing: " + task);
        }

    }
}
