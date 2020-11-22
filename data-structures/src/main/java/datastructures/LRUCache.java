package datastructures;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    Map<Integer, Integer> hashmap = new LinkedHashMap<>();
    int cache_size;

    public LRUCache(int capacity) {
        cache_size = capacity;
    }

    private int get(int key) {
        if (!hashmap.containsKey(key))
            return -1;
        int value = hashmap.get(key);
        hashmap.remove(key);
        hashmap.put(key, value);
        return value;
    }

    private void put(int key, int value) {
        if (!hashmap.containsKey(key)) {
            if (hashmap.size() == cache_size) {
                int first_key = hashmap.keySet().iterator().next();
                hashmap.remove(first_key);
            }
            hashmap.put(key, value);
        } else {
            hashmap.remove(key);
            hashmap.put(key, value);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}