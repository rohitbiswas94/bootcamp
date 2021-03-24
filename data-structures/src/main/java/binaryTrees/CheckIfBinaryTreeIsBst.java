package binaryTrees;

import binaryTrees.node.Node;

public class CheckIfBinaryTreeIsBst {

    private static Node prev;

    private static boolean isValidBST(Node root) {
        prev = null;
        return checkIsBst(root);
    }

    private static boolean checkIsBst(Node node) {
        if (node != null) {
            if (!checkIsBst(node.left)) return false;
            if (prev != null && node.data <= prev.data) return false;
            prev = node;
            return checkIsBst(node.right);
        }
        return true;
    }

    public static void main(String[] args){
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(5);
        root.right.right = new Node(6);
        System.out.println(isValidBST(root));
    }
}
