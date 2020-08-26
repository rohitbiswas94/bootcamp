package binaryTrees;

import binaryTrees.node.Node;

public class CompleteBinaryTree {

    Node root;

    private int isComplete(final Node node) {
        if (node == null) {
            return 1;
        } else {
            final int noOfLeftChildNodes = noOfChildNodes(node.left);
            final int noOfRightChildNodes = noOfChildNodes(node.right);
            if ((noOfLeftChildNodes - noOfRightChildNodes) <= 2 && noOfLeftChildNodes >= noOfRightChildNodes
                    && isComplete(node.left) == 1 && isComplete(node.right) == 1) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }

    private int noOfChildNodes(final Node node) {
        if (node == null) {
            return 0;
        }
        else {
            return 1 + noOfChildNodes(node.left) + noOfChildNodes(node.right);
        }
    }

    public static void main(String args[])
    {
        CompleteBinaryTree tree = new CompleteBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        if (tree.isComplete(tree.root) == 1)
            System.out.println("The tree is a complete binary tree");
        else
            System.out.println("The tree is not a complete tree");
    }
}
