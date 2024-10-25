package org.example.oop_exercise_4;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<T> {
    private final ArrayList<T> elements;

    //Constructor to initialize the stack
    public Stack() {
        this.elements = new ArrayList<>();
    }

    //Push an element onto the stack
    public void push(T value) {
        elements.add(value);
    }

    //Pop an element from the top of the stack
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }

    boolean isEmpty() {
        return elements.isEmpty();
    }

    //Peek at the top element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.get(elements.size() - 1);
    }

    //Get the current size of the stack
    public int size() {
        return elements.size();
    }
}
