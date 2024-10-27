package org.example.advanced_algorithms_exercise_4;

import java.util.*;

class Graph {
    private Map<Integer, List<Integer>> adjacencyList;

    // Constructor: Initializes the adjacency list
    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Add an edge between two nodes (u -> v)
    public void addEdge(int u, int v) {
        adjacencyList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adjacencyList.computeIfAbsent(v, k -> new ArrayList<>()).add(u); // For an undirected graph
    }

    // Perform Depth-First Search (DFS)
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(start, visited);
    }

    // Helper function for recursive DFS
    private void dfsRecursive(int node, Set<Integer> visited) {
        if (visited.contains(node)) {
            return;
        }

        // Mark the node as visited and print it
        visited.add(node);
        System.out.print(node + " ");

        // Visit all unvisited neighbors
        for (int neighbor : adjacencyList.getOrDefault(node, new ArrayList<>())) {
            dfsRecursive(neighbor, visited);
        }
    }

    // Display the adjacency list (for debugging)
    public void printGraph() {
        for (var entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
