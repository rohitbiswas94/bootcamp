package binaryTrees;

import binaryTrees.node.Node;

public class MirrorTree {

    Node root;

    private Node convertToMirror(Node node) {
        if (node == null)
            return node;
        Node left = convertToMirror(node.left);
        Node right = convertToMirror(node.right);
        node.left = right;
        node.right = left;
        return node;
    }

    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.data + "\t");
        inOrder(node.right);
    }

    public static void main(String[] args) {
        MirrorTree tree = new MirrorTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.inOrder(tree.root);
        tree.convertToMirror(tree.root);
        tree.inOrder(tree.root);
    }
}
