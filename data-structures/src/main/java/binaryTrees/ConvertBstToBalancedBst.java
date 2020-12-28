package binaryTrees;

import binaryTrees.node.Node;

import java.util.ArrayList;
import java.util.List;

public class ConvertBstToBalancedBst {

    Node root;

    private static Node convertBst(List<Node> nodes, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        Node node = nodes.get(mid);
        node.left = convertBst(nodes, start, mid - 1);
        node.right = convertBst(nodes, mid + 1, end);
        return node;

    }

    private static void storeBstNodes(List<Node> nodes, Node node) {
        if (node == null) return;
        storeBstNodes(nodes, node.left);
        nodes.add(node);
        storeBstNodes(nodes, node.right);
    }

    private static Node buildBalancedBst(Node root) {
        List<Node> nodes = new ArrayList<>();
        storeBstNodes(nodes, root);
        return convertBst(nodes, 0, nodes.size() - 1);
    }

    private static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + "\t");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        ConvertBstToBalancedBst tree = new ConvertBstToBalancedBst();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(7);
        tree.root.left.left.left = new Node(6);
        tree.root.left.left.left.left = new Node(5);
        tree.root = buildBalancedBst(tree.root);
        System.out.println("Preorder traversal of balanced BST is :");
        preOrder(tree.root);
    }

}
