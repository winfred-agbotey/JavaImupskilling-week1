package org.example.advanced_algorithms_exercise_1;

class AVLTree {

    class Node {
        int key;
        int height;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
            height = 1; // Height starts at 1 when node is created.
        }
    }

    private Node root;

    // Helper method to get the height of a node.
    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    // Helper method to calculate the balance factor of a node.
    private int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    // Perform a right rotation.
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation.
        x.right = y;
        y.left = T2;

        // Update heights.
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x; // New root after rotation.
    }

    // Perform a left rotation.
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation.
        y.left = x;
        x.right = T2;

        // Update heights.
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y; // New root after rotation.
    }

    // Insert a key into the AVL Tree.
    public void insert(int key) {
        root = insertNode(root, key);
    }

    private Node insertNode(Node node, int key) {
        if (node == null) {
            return new Node(key); // New node is created.
        }

        // Perform standard BST insertion.
        if (key < node.key) {
            node.left = insertNode(node.left, key);
        } else if (key > node.key) {
            node.right = insertNode(node.right, key);
        } else {
            return node; // Duplicate keys are not allowed.
        }

        // Update the height of this ancestor node.
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Check the balance factor to see if rebalancing is needed.
        int balance = getBalance(node);

        // Perform rotations to restore AVL property.
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node); // Left-Left case.
        }

        if (balance < -1 && key > node.right.key) {
            return leftRotate(node); // Right-Right case.
        }

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left); // Left-Right case.
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right); // Right-Left case.
            return leftRotate(node);
        }

        return node; // Return the unchanged node pointer.
    }

    // Delete a key from the AVL Tree.
    public void delete(int key) {
        root = deleteNode(root, key);
    }

    private Node deleteNode(Node node, int key) {
        if (node == null) return node;

        // Perform standard BST deletion.
        if (key < node.key) {
            node.left = deleteNode(node.left, key);
        } else if (key > node.key) {
            node.right = deleteNode(node.right, key);
        } else {
            // Node with one child or no child.
            if ((node.left == null) || (node.right == null)) {
                Node temp = (node.left != null) ? node.left : node.right;

                // No child case.
                if (temp == null) {
                    temp = node;
                    node = null;
                } else {
                    node = temp; 
                }
            } else {
                // Node with two children: Get the inorder successor.
                Node temp = minValueNode(node.right);

                // Copy the inorder successor's key to this node.
                node.key = temp.key;

                // Delete the inorder successor.
                node.right = deleteNode(node.right, temp.key);
            }
        }

        // If the tree had only one node, return.
        if (node == null) return node;

        // Update height.
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // Check the balance factor to rebalance the tree.
        int balance = getBalance(node);

        // Perform rotations to restore AVL property.
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node); // Left-Left case.
        }

        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left); // Left-Right case.
            return rightRotate(node);
        }

        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node); // Right-Right case.
        }

        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right); // Right-Left case.
            return leftRotate(node);
        }

        return node;
    }

    // Get the node with the smallest key value.
    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Search for a key in the AVL Tree.
    public boolean search(int key) {
        return searchNode(root, key);
    }

    private boolean searchNode(Node node, int key) {
        if (node == null) return false;
        if (key == node.key) return true;
        if (key < node.key) return searchNode(node.left, key);
        return searchNode(node.right, key);
    }

    // In-order traversal to print the AVL Tree.
    public void inOrderTraversal() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

}