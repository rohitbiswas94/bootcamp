package binaryTrees;

import binaryTrees.node.Node;

import java.util.Map;
import java.util.LinkedHashMap;

public class VerticalSumBinaryTree {
    Node root;
    LinkedHashMap<Integer, Integer> hmap;

    private VerticalSumBinaryTree() {
        root = null;
        hmap = new LinkedHashMap<>();
    }

    private void findVerticalSum(final Node node, final int key) {
        if (node == null) {
            return;
        }
        if (hmap.containsKey(key)) {
            hmap.put(key, hmap.get(key) + node.data);
        }
        else {
            hmap.put(key, node.data);
        }
        findVerticalSum(node.left, key - 1);
        findVerticalSum(node.right, key + 1);
    }

    private void display() {
        for (final Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            System.out.println("Sum of Vertical Line " + entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void main(final String[] args) {
        final VerticalSumBinaryTree tree = new VerticalSumBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.findVerticalSum(tree.root, 0);
        tree.display();
    }
}