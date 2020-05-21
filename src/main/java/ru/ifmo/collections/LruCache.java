package ru.ifmo.collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents LRU cache with fixed maximum capacity.
 * <p>
 * get() should return null if there is no value for a given key.
 * elements() should return number of elements in cache.
 * <p>
 * This class should not have any other public methods.
 * <p>
 * Implementing this cache in (almost) the same manner as it was implemented during the lecture will result in extra points.
 */
public class LruCache<K, V> {

    private static final float LOAD_FACTOR = 1f;
    private final int capacity;
    private final LinkedHashMap<K, V> linkedHashMap;

    public LruCache(int initialCapacity) {
        linkedHashMap = new LinkedHashMap<>(initialCapacity, LOAD_FACTOR, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > capacity;
            }
        };
        this.capacity = initialCapacity;
    }

    public V get(Object key) {
        return linkedHashMap.get(key);
    }

    public void put(K key, V value) {
        linkedHashMap.put(key, value);
    }

    public int elements() {
        return linkedHashMap.size();
    }

}