package binaryTrees;

import binaryTrees.node.Node;

public class LowestCommonAncestorBt {

    private Node root;

    private Node lowestCommonAncestor(final Node node, final int nodeData1, final int nodeData2) {
        if (node == null) {
            return null;
        }
        if(node.data == nodeData1 || node.data == nodeData2) {
            return node;
        }
        final Node left = lowestCommonAncestor(node.left, nodeData1, nodeData2);
        final Node right = lowestCommonAncestor(node.right, nodeData1, nodeData2);
        if(left != null & right != null) {
            return node;
        }
        return left != null ? left : right;
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
        System.out.println(lca.lowestCommonAncestor(lca.root, 4, 5).data);
        System.out.println(lca.lowestCommonAncestor(lca.root, 4, 6).data);
        System.out.println(lca.lowestCommonAncestor(lca.root, 3, 4).data);
        System.out.println(lca.lowestCommonAncestor(lca.root, 2, 4).data);

    }
}
