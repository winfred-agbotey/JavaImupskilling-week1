package org.example.algorithm_exercise_1;

import java.util.Arrays;
import java.util.List;

import static org.example.algorithm_exercise_1.FractionalKnapsack.getMaxValue;

public class Main {
    public static void main(String[] args) {
        // List of items with their weights and values
        List<Item> items = Arrays.asList(
                new Item(10, 60),  // Item 1: weight = 10, value = 60
                new Item(20, 100), // Item 2: weight = 20, value = 100
                new Item(30, 120)  // Item 3: weight = 30, value = 120
        );

        double capacity = 50; // Knapsack capacity

        double maxValue = FractionalKnapsack.getMaxValue(items, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
