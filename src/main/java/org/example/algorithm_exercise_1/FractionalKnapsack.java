package org.example.algorithm_exercise_1;

import java.util.List;

public class FractionalKnapsack {

    public static double getMaxValue(List<Item> items, double capacity) {
        // Sort items by value-to-weight ratio in descending order
        items.sort((a, b) -> Double.compare(b.getRatio(), a.getRatio()));

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity <= 0) break; // Knapsack is full

            // If the entire item can fit, take it
            if (item.weight <= capacity) {
                totalValue += item.value;
                capacity -= item.weight;
            }
            // Otherwise, take a fraction of the item
            else {
                totalValue += item.getRatio() * capacity;
                capacity = 0; // Knapsack is now full
            }
        }

        return totalValue;
    }
}