package binaryTrees;

import binaryTrees.node.Node;

public class InOrderSuccessorBST {

    Node root;

    private Node findInOrderSuccessorOfBst(Node root, Node node, Node ios) {
        if (root == null)
            return null;
        if (root.data > node.data) {
            ios.data = root.data < ios.data ? root.data : ios.data;
            findInOrderSuccessorOfBst(root.left, node, ios);
        } else {
            findInOrderSuccessorOfBst(root.right, node, ios);
        }
        return ios;
    }

    public static void main(String args[]) {
        InOrderSuccessorBST tree = new InOrderSuccessorBST();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        Node ios = tree.findInOrderSuccessorOfBst(tree.root, new Node(22), new Node(Integer.MAX_VALUE));
        System.out.println(ios.data);
    }
}
