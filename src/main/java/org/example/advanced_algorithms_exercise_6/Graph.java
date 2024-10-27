package org.example.advanced_algorithms_exercise_6;

import java.util.*;

class Graph {
    private Map<String, List<Edge>> adjacencyList;

    // Constructor to initialize the adjacency list
    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Add an edge between two cities with a given cost
    public void addEdge(String city1, String city2, int cost) {
        adjacencyList.computeIfAbsent(city1, k -> new ArrayList<>())
                .add(new Edge(city1, city2, cost));
        adjacencyList.computeIfAbsent(city2, k -> new ArrayList<>())
                .add(new Edge(city2, city1, cost)); // For undirected graph
    }

    // Prim's Algorithm to find the Minimum Spanning Tree (MST)
    public List<Edge> primMST(String startCity) {
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.cost));
        Set<String> visited = new HashSet<>();
        List<Edge> mst = new ArrayList<>();

        // Add all edges from the starting city to the min-heap
        visited.add(startCity);
        minHeap.addAll(adjacencyList.get(startCity));

        // Continue until the MST spans all cities
        while (!minHeap.isEmpty() && visited.size() < adjacencyList.size()) {
            Edge minEdge = minHeap.poll();

            // Check if the edge connects a visited city with an unvisited city
            String nextCity = visited.contains(minEdge.city1) ? minEdge.city2 : minEdge.city1;
            if (visited.contains(nextCity)) continue; // Skip if already visited

            // Add the edge to the MST and mark the new city as visited
            mst.add(minEdge);
            visited.add(nextCity);

            // Add all new edges from the newly visited city to the min-heap
            for (Edge edge : adjacencyList.getOrDefault(nextCity, new ArrayList<>())) {
                if (!visited.contains(edge.city2)) {
                    minHeap.add(edge);
                }
            }
        }

        return mst;
    }
}