package binaryTrees;

import binaryTrees.node.Node;
import javafx.util.Pair;

import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class SidewaysTraversalBinaryTree {

    Node root;
    final Queue<Pair<Integer, Node>> queue = new LinkedList<>();
    final Map<Integer, List<Node>> mapOfNodesByLevel = new HashMap<>();

    //creates a map of all levels of the tree in level order traversal
    private void populateNodesByLevel(final Node root) {
        if (root == null) {
            return;
        }
        queue.add(new Pair<>(0, root));
        while (!queue.isEmpty()) {
            final Pair<Integer, Node> nodePair = queue.poll();
            int nodeLevel = nodePair.getKey();
            Node node = nodePair.getValue();
            if (mapOfNodesByLevel.containsKey(nodeLevel)) {
                final List<Node> nodes = new LinkedList<>(mapOfNodesByLevel.get(nodeLevel));
                nodes.add(node);
                mapOfNodesByLevel.put(nodeLevel, nodes);
            } else {
                final List<Node> nodes = new LinkedList<>();
                nodes.add(node);
                mapOfNodesByLevel.put(nodeLevel, nodes);
            }
            if (node.left != null) {
                queue.add(new Pair<>(nodeLevel + 1, node.left));
            }
            if (node.right != null) {
                queue.add(new Pair<>(nodeLevel + 1, node.right));
            }
        }
    }

    private void displayNodes() {
        final List<Integer> sidewaysNodes = new LinkedList<>();
        final List<List<Node>> updatedNodes = new LinkedList<>();
        for (Map.Entry<Integer, List<Node>> entry : mapOfNodesByLevel.entrySet()) {
            final List<Node> nodes = entry.getValue();
            sidewaysNodes.add(entry.getValue().get(nodes.size() - 1).data);
            nodes.remove(nodes.size() - 1);
            if (!nodes.isEmpty()) {
                updatedNodes.add(nodes);
            }
        }
        int direction = 1; // 0 -> right to left / 1 -> left to right
        Collections.reverse(updatedNodes);
        for (final List<Node> nodes : updatedNodes) {
            if (direction == 1) {
                Collections.reverse(nodes);
                nodes.forEach(node -> sidewaysNodes.add(node.data));
                direction = 0;
            } else {
                nodes.forEach(node -> sidewaysNodes.add(node.data));
                direction = 1;
            }
        }
        System.out.println(sidewaysNodes);
    }

    public static void main(String args[]) {
        SidewaysTraversalBinaryTree tree = new SidewaysTraversalBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(11);
        tree.populateNodesByLevel(tree.root);
        tree.displayNodes();
    }
}
