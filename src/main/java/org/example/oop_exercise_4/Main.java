package org.example.oop_exercise_4;

public class Main {
    public static void main(String[] args) {
        // Stack of Integers
        Stack<Integer> intStack = new Stack<>();
        intStack.push(10);
        intStack.push(20);
        System.out.println("Peek: " + intStack.peek()); // 20
        System.out.println("Pop: " + intStack.pop());   // 20
        System.out.println("Is Empty: " + intStack.isEmpty()); //false

        // Stack of Strings
        Stack<String> stringStack = new Stack<>();
        stringStack.push("Hello");
        stringStack.push("World");
        System.out.println("Peek: " + stringStack.peek()); // World
        System.out.println("Pop: " + stringStack.pop());   // World
        System.out.println("Is Empty: " + stringStack.isEmpty()); // false
    }
}
