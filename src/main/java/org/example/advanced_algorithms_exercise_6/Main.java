package org.example.advanced_algorithms_exercise_6;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Define the city connections with their costs
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 1);
        graph.addEdge("B", "D", 2);
        graph.addEdge("C", "D", 4);
        graph.addEdge("C", "E", 2);
        graph.addEdge("D", "E", 3);

        // Find the Minimum Spanning Tree (MST) starting from city A
        List<Edge> mst = graph.primMST("A");

        // Display the edges in the MST and the total cost
        System.out.println("Minimum Spanning Tree (MST):");
        int totalCost = 0;
        for (Edge edge : mst) {
            System.out.println(edge.city1 + " - " + edge.city2 + " : " + edge.cost);
            totalCost += edge.cost;
        }
        System.out.println("Total Cost: " + totalCost);
    }
}
