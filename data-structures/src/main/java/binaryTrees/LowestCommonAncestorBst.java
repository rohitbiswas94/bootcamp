package binaryTrees;

import binaryTrees.node.Node;

public class LowestCommonAncestorBst {

    private Node root;

    private Node lowestCommonAncestor(final Node node, int nodeData1, int nodeData2) {
        if (node == null) {
            return null;
        }
        if (nodeData1 < node.data && nodeData2 < node.data) {
            return lowestCommonAncestor(node.left, nodeData1, nodeData2);
        }
        if (nodeData1 > node.data && nodeData2 > node.data) {
            return lowestCommonAncestor(node.right, nodeData1, nodeData2);
        }
        return node;
    }

    private void displayLca(final Node node, int nodeData1, int nodeData2) {
        System.out.println("The Lowest Common Ancestor for "+ nodeData1 + " and " + nodeData2 + " = " + node.data);
    }

    public static void main(String[] args) {
        LowestCommonAncestorBst lca = new LowestCommonAncestorBst();
        lca.root = new Node(20);
        lca.root.left = new Node(8);
        lca.root.right = new Node(22);
        lca.root.left.left = new Node(4);
        lca.root.left.right = new Node(12);
        lca.root.left.right.left = new Node(10);
        lca.root.left.right.right = new Node(14);
        lca.displayLca(lca.lowestCommonAncestor(lca.root, 10, 14), 10, 14);
        lca.displayLca(lca.lowestCommonAncestor(lca.root, 14, 8), 14, 8);
        lca.displayLca(lca.lowestCommonAncestor(lca.root, 10, 22), 10, 22);

    }
}
