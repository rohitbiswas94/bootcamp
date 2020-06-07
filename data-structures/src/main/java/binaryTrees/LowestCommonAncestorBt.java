package binaryTrees;

import binaryTrees.node.Node;

public class LowestCommonAncestorBt {

    private Node root;
    static boolean value1;
    static boolean value2;

    private Node lowestCommonAncestorUtil(final Node node, final int nodeData1, final int nodeData2) {
        if (node == null) {
            return null;
        }
        if (node.data == nodeData1) {
            value1 = true;
            return node;
        }
        if (node.data == nodeData2) {
            value2 = true;
            return node;
        }
        final Node left = lowestCommonAncestorUtil(node.left, nodeData1, nodeData2);
        final Node right = lowestCommonAncestorUtil(node.right, nodeData1, nodeData2);
        if (left != null & right != null) {
            return node;
        }
        return left != null ? left : right;
    }

    private void lowestCommonAncestor(final int nodeData1, final int nodeData2) {
        value1 = false;
        value2 = false;
        final Node lca = lowestCommonAncestorUtil(root, nodeData1, nodeData2);
        if (value1 && value2) {
            System.out.println(lca.data);
        } else {
            System.out.println("No Lowest Common Ancestor found for " + nodeData1 + " and " + nodeData2);
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestorBt lca = new LowestCommonAncestorBt();
        lca.root = new Node(1);
        lca.root.left = new Node(2);
        lca.root.right = new Node(3);
        lca.root.left.left = new Node(4);
        lca.root.left.right = new Node(5);
        lca.root.right.left = new Node(6);
        lca.root.right.right = new Node(7);
        lca.lowestCommonAncestor(4, 5);
        lca.lowestCommonAncestor(4, 6);
        lca.lowestCommonAncestor(3, 4);
        lca.lowestCommonAncestor(2, 3);
        lca.lowestCommonAncestor(2, 8);

    }
}
