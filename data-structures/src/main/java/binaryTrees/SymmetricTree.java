package binaryTrees;

import binaryTrees.node.Node;

public class SymmetricTree {

    Node root;

    private boolean isSymmetric(final Node node1, final Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        return node1 != null && node2 != null && node1.data == node2.data
                && isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }

    public static void main(String args[]) {
        SymmetricTree tree = new SymmetricTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(3);
        if (tree.isSymmetric(tree.root, tree.root)) {
            System.out.println("Tree is Symmetric");
        } else {
            System.out.println("Tree is not Symmetric");
        }
    }
}
