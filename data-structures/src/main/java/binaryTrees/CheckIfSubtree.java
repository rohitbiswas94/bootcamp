/*
 Given two non-empty binary trees s and t, check whether tree t has exactly the same structure
 and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all
 of this node's descendants. The tree s could also be considered as a subtree of itself.
 */

package binaryTrees;

import binaryTrees.node.Node;

public class CheckIfSubtree {

    private static boolean isSubtree(Node treeNode, Node subTreeNode) {
        if (treeNode == null) return false;
        boolean left = isSubtree(treeNode.left, subTreeNode);
        boolean isPresent = checkIfSubtree(treeNode, subTreeNode);
        boolean right = isSubtree(treeNode.right, subTreeNode);
        return left || right || isPresent;
    }

    private static boolean checkIfSubtree(Node treeNode, Node subTreeNode) {
        if (treeNode == null && subTreeNode == null) return true;
        if (treeNode == null || subTreeNode == null) return false;
        return treeNode.data == subTreeNode.data
                && checkIfSubtree(treeNode.left, subTreeNode.left)
                && checkIfSubtree(treeNode.right, subTreeNode.right);
    }

    public static void main(String[] args) {
        Node tree = new Node(26);
        tree.left = new Node(10);
        tree.left.left = new Node(4);
        tree.left.left.right = new Node(30);
        tree.left.right = new Node(6);
        tree.right = new Node(3);
        tree.right.right = new Node(3);
        Node subTree = new Node(10);
        subTree.left = new Node(4);
        subTree.left.right = new Node(30);
        subTree.right = new Node(6);
        boolean found = isSubtree(tree, subTree);
        System.out.println(found);
    }
}
