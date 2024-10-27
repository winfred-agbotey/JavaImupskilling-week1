package org.example.advanced_algorithms_exercise_5;

import java.util.*;

class Graph {
    private Map<String, List<Edge>> adjacencyList;

    // Constructor: Initialize the adjacency list
    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Add an edge between two cities with a weight (distance)
    public void addEdge(String source, String destination, int weight) {
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>())
                .add(new Edge(destination, weight));
        adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>())
                .add(new Edge(source, weight)); // For undirected graph
    }

    // Dijkstra's Algorithm to find the shortest path from start to end
    public Map<String, Integer> dijkstra(String start) {
        // Priority Queue to get the minimum distance node
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        Map<String, Integer> distances = new HashMap<>(); // Track shortest distances
        Set<String> visited = new HashSet<>(); // Track visited nodes

        // Initialize all distances to infinity, except the start node
        for (String city : adjacencyList.keySet()) {
            distances.put(city, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        pq.add(new Node(start, 0));

        // Main loop to process nodes
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            String currentCity = current.city;

            if (visited.contains(currentCity)) continue; // Skip if already visited
            visited.add(currentCity);

            // Explore neighbors
            for (Edge edge : adjacencyList.getOrDefault(currentCity, new ArrayList<>())) {
                String neighbor = edge.destination;
                int newDistance = distances.get(currentCity) + edge.weight;

                // Update if a shorter path is found
                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    pq.add(new Node(neighbor, newDistance));
                }
            }
        }
        return distances;
    }
}

// Class to represent an edge (road) between cities
class Edge {
    String destination;
    int weight;

    public Edge(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

// Class to represent a node in the priority queue
class Node {
    String city;
    int distance;

    public Node(String city, int distance) {
        this.city = city;
        this.distance = distance;
    }
}


