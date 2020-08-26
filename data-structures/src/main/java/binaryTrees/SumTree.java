package binaryTrees;

import binaryTrees.node.Node;

public class SumTree {

    Node root;

    private int isSumTree(final Node node) {
        if (node == null || (node.left == null && node.right == null)) {
            return 1;
        }
        final int left = sum(node.left);
        final int right = sum(node.right);
        if(node.data == (left+right) && isSumTree(node.left) == 1 && isSumTree(node.right) == 1){
            return 1;
        } else {
            return 0;
        }
    }

    private int sum(final Node node) {
        if(node == null) {
            return 0;
        }
        return node.data + sum(node.left) + sum(node.right);
    }

    public static void main(String args[])
    {
        SumTree tree = new SumTree();
        tree.root = new Node(26);
        tree.root.left = new Node(10);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.right.right = new Node(3);

        if (tree.isSumTree(tree.root) == 1)
            System.out.println("The tree is a sum tree");
        else
            System.out.println("The tree is not a sum tree");
    }
}
