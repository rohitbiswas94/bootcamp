package binaryTrees;

import binaryTrees.node.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    Node root;

    private void levelOrderTraversal(final Node root) {
        if (root == null) {
            System.out.println("Tree is empty");
        } else {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                System.out.println(node.data);
                if(node.left!= null)
                    queue.add(node.left);
                if(node.right!= null)
                    queue.add(node.right);
            }
        }
    }

    public static void main(String args[]) {
        LevelOrderTraversal tree = new LevelOrderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.levelOrderTraversal(tree.root);
    }


}
