package org.example.advanced_algorithms_exercise_5;

import java.util.Map;


public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Define the road network
        graph.addEdge("A", "B", 10);
        graph.addEdge("A", "C", 15);
        graph.addEdge("B", "D", 12);
        graph.addEdge("C", "E", 10);
        graph.addEdge("D", "E", 2);
        graph.addEdge("D", "C", 1);

        // Run Dijkstra's algorithm from city A
        Map<String, Integer> shortestPaths = graph.dijkstra("A");

        // Display the shortest distances from A to all cities
        System.out.println("Shortest distances from A:");
        for (Map.Entry<String, Integer> entry : shortestPaths.entrySet()) {
            System.out.println("To " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}


