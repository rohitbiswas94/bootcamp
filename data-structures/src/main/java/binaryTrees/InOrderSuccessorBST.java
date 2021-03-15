package binaryTrees;

import binaryTrees.node.Node;

public class InOrderSuccessorBST {

    Node root;

    private Node findInOrderSuccessorOfBst(Node root, Node node) {
        if (node.right != null) return findMinValue(node.right);
        Node ios = root;
        while (root != null) {
            if (node.data < root.data) {
                ios = root;
                root = root.left;
            } else if (node.data > root.data)
                root = root.right;
            else break;
        }
        return ios;
    }

    private Node findMinValue(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    public static void main(String args[]) {
        InOrderSuccessorBST tree = new InOrderSuccessorBST();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        Node node = tree.root.left.right.left;
        Node ios = tree.findInOrderSuccessorOfBst(tree.root, node);
        System.out.println(ios.data);
    }
}
