package org.example.advanced_algorithms_exercise_3;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insert words into the Trie
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        trie.insert("banana");
        trie.insert("band");
        trie.insert("banana");
        trie.insert("cat");
        trie.insert("car");

        // Test search functionality
        System.out.println("Search 'apple': " + trie.search("apple")); // true
        System.out.println("Search 'app': " + trie.search("app")); // true
        System.out.println("Search 'appl': " + trie.search("appl")); // false

        // Test startsWith functionality
        System.out.println("Starts with 'ban': " + trie.startsWith("ban")); // true
        System.out.println("Starts with 'zoo': " + trie.startsWith("zoo")); // false

        // Test autocomplete functionality
        System.out.println("Autocomplete 'app': " + trie.autocomplete("app"));
        System.out.println("Autocomplete 'ban': " + trie.autocomplete("ban"));
        System.out.println("Autocomplete 'c': " + trie.autocomplete("c"));
    }
}

