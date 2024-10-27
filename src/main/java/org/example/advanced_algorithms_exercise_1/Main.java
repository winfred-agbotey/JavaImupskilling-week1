package org.example.advanced_algorithms_exercise_1;

public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Insert nodes.
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        System.out.println("In-order traversal after insertion:");
        tree.inOrderTraversal();

        // Search for a node.
        System.out.println("Search for 30: " + tree.search(30));

        // Delete a node.
        tree.delete(20);
        System.out.println("In-order traversal after deletion:");
        tree.inOrderTraversal();
    }
}
