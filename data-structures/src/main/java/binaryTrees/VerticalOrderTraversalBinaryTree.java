/*
    Keep in mind the (col, row) concept. It should be represented in such a way that all the nodes
    of the same row should be in ascending order and the vertical nodes in their order of top to bottom.
    Ex - Draw the input given in the main func.

*/
package binaryTrees;

import binaryTrees.node.Node;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Arrays;

public class VerticalOrderTraversalBinaryTree {

    Node root;

    private void verticalTraversal(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        Map<Integer, Map<Integer, List<Integer>>> map = traverse(root, new TreeMap<>(), 0, 0);
        for (Map.Entry<Integer, Map<Integer, List<Integer>>> entry : map.entrySet()) {
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> rowEntry : entry.getValue().entrySet()) {
                List<Integer> sortedList = rowEntry.getValue();
                Collections.sort(sortedList);
                list.addAll(sortedList);
            }
            lists.add(list);
        }
        lists.forEach(System.out::print);
    }

    private Map<Integer, Map<Integer, List<Integer>>> traverse(Node root,
                                                               Map<Integer, Map<Integer, List<Integer>>> map,
                                                               int col,
                                                               int row) {
        if (root == null) return map;
        if (map.containsKey(col)) {
            Map<Integer, List<Integer>> rowMap = map.get(col);
            if (rowMap.containsKey(row)) {
                List<Integer> list = rowMap.get(row);
                list.add(root.data);
                rowMap.put(row, list);
            } else {
                rowMap.put(row, new ArrayList<>(Collections.singletonList(root.data)));
            }
            map.put(col, rowMap);
        } else {
            Map<Integer, List<Integer>> rowMap = new TreeMap<>();
            rowMap.put(row, new ArrayList<>(Collections.singletonList(root.data)));
            map.put(col, rowMap);
        }
        traverse(root.left, map, col - 1, row + 1);
        traverse(root.right, map, col + 1, row + 1);
        return map;
    }

    public static void main(String[] args) {
        VerticalOrderTraversalBinaryTree tree = new VerticalOrderTraversalBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(6);
        tree.root.left.right = new Node(7);
        tree.root.left.right.left = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.left = new Node(8);
        tree.root.right.left = new Node(3);
        tree.verticalTraversal(tree.root);
    }
}
