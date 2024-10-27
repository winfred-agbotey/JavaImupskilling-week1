package org.example.advanced_algorithms_exercise_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        current.isEndOfWord = true;
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isEndOfWord;
    }

    // Check if there is any word that starts with the given prefix
    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    // Find the Trie node that matches the end of a given prefix or word
    private TrieNode findNode(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            current = current.children.get(ch);
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    // Retrieve a list of all words that start with a given prefix
    public List<String> autocomplete(String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode node = findNode(prefix);
        if (node != null) {
            dfs(node, new StringBuilder(prefix), results);
        }
        return results;
    }

    // Depth-First Search to collect all words starting from a given node
    private void dfs(TrieNode node, StringBuilder prefix, List<String> results) {
        if (node.isEndOfWord) {
            results.add(prefix.toString());
        }
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            prefix.append(entry.getKey());
            dfs(entry.getValue(), prefix, results);
            prefix.deleteCharAt(prefix.length() - 1); // Backtrack
        }
    }
}
