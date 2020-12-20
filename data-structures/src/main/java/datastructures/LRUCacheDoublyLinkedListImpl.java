package datastructures;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheDoublyLinkedListImpl {

    Map<Integer, Node> hmap = new HashMap<>();
    Node head;
    Node tail;
    int cache_size;

    class Node {
        int value;
        int key;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
            prev = null;
        }
    }

    LRUCacheDoublyLinkedListImpl(int capacity) {
        cache_size = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void deleteNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private int get(int key) {
        if (!hmap.containsKey(key))
            return -1;
        else {
            Node node = hmap.get(key);
            deleteNode(node);
            addToHead(node);
            return node.value;
        }
    }

    private void put(int key, int value) {
        if (!hmap.containsKey(key)) {
            if (hmap.size() == cache_size) {
                hmap.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
            Node node = new Node(key, value);
            hmap.put(key, node);
            addToHead(node);
        } else {
            Node node = hmap.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCacheDoublyLinkedListImpl lruCache = new LRUCacheDoublyLinkedListImpl(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        lruCache.put(5, 5);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(5));
    }

}
