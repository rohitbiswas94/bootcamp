package binaryTrees;

import binaryTrees.node.Node;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfTree {


    private static int getMaxWidth(Node root){
        if (root == null) return 0;
        int maxWidth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int nodesInLevel = queue.size();
            maxWidth = Math.max(nodesInLevel, maxWidth);
            while (nodesInLevel > 0) {
                Node node = queue.remove();
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
                nodesInLevel--;
            }
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.right = new Node(8);
        System.out.println(getMaxWidth(root));
    }
}
