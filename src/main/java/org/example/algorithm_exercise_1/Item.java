package org.example.algorithm_exercise_1;

class Item {
    double weight;
    double value;

    public Item(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    // Calculate the value-to-weight ratio for sorting
    public double getRatio() {
        return value / weight;
    }
}