package org.example.oop_exercise_5;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCache<K, V> {
    private final ConcurrentHashMap<K, V> cache;

    public InMemoryCache() {
        this.cache = new ConcurrentHashMap<>();
    }

    // Put a key-value pair into the cache
    public void put(K key, V value) {
        cache.put(key, value);
    }

    // Get a value from the cache based on the key
    public V get(K key) {
        return cache.get(key);
    }

    //Remove a key value pair from the cache
    public void remove(K key) {
        cache.remove(key);
    }

    // Check if the cache contains a specific key
    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }

    // Clear the entire cache
    public void clear() {
        cache.clear();
    }

    // Get the current size of the cache
    public int size() {
        return cache.size();
    }
}
