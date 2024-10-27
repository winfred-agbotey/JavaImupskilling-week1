package org.example.advanced_algorithms_exercise_2;

// Task class to represent a task with a name and priority.
public class Task implements Comparable<Task> {
    private final String name;
    private final int priority; // Lower values indicate higher priority.

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    // Overriding compareTo to order tasks by priority (Min Heap behavior).
    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Task: " + name + ", Priority: " + priority;
    }
}
