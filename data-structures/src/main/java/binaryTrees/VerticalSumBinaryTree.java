package binaryTrees;

import binaryTrees.node.Node;

import java.util.Map;
import java.util.LinkedHashMap;

public class VerticalSumBinaryTree {
    Node root;
    LinkedHashMap<Integer, Integer> hmap;

    public VerticalSumBinaryTree() {
        this.root = null;
        this.hmap = new LinkedHashMap<>();
    }

    public void findVerticalSum(final Node node, final int key) {
        if (node == null) {
            return;
        }
        this.findVerticalSum(node.left, key - 1);
        if (this.hmap.containsKey(key)) {
            this.hmap.put(key, this.hmap.get(key) + node.data);
        }
        else {
            this.hmap.put(key, node.data);
        }
        this.findVerticalSum(node.right, key + 1);
    }

    public void display() {
        for (final Map.Entry<Integer, Integer> entry : this.hmap.entrySet()) {
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
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(6);
        tree.findVerticalSum(tree.root, 0);
        tree.display();
    }
}