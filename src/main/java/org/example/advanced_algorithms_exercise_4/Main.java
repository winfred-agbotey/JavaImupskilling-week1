package org.example.advanced_algorithms_exercise_4;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        // Print the graph
        System.out.println("Graph adjacency list:");
        graph.printGraph();

        // Perform DFS traversal from node 0
        System.out.println("\nDFS Traversal starting from node 0:");
        graph.dfs(0);
    }
}
