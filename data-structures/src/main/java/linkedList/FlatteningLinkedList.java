package linkedList;

public class FlatteningLinkedList {

    Node head;

    private static class Node {
        int val;
        Node right;
        Node down;

        Node(int val) {
            this.val = val;
            this.right = null;
            this.down = null;
        }
    }

    private Node merge(Node root1, Node root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        Node flattenNodes = new Node(-1);
        Node curr = flattenNodes;
        while (root1 != null && root2 != null) {
            if (root1.val < root2.val) {
                curr.down = root1;
                root1 = root1.down;
            } else {
                curr.down = root2;
                root2 = root2.down;
            }
            curr = curr.down;
        }
        curr.down = root1 == null ? root2 : root1;
        return flattenNodes.down;
    }

    private Node flatten(Node root) {
        if (root == null || root.right == null) return root;
        flatten(root.right);
        return root.right = merge(root, root.right);
    }

    private Node insert(Node root, int val) {
        Node node = new Node(val);
        node.down = root;
        root = node;
        return root;
    }

    private void display() {
        Node root = head;
        while (root != null) {
            System.out.print(root.val + "\t");
            root = root.down;
        }
    }

    public static void main(String[] args) {
        FlatteningLinkedList fll = new FlatteningLinkedList();

        fll.head = new Node(30);
        fll.head = fll.insert(fll.head, 8);
        fll.head = fll.insert(fll.head, 7);
        fll.head = fll.insert(fll.head, 5);

        fll.head.right = new Node(20);
        fll.head.right = fll.insert(fll.head.right, 10);

        fll.head.right.right = new Node(50);
        fll.head.right.right = fll.insert(fll.head.right.right, 22);
        fll.head.right.right = fll.insert(fll.head.right.right, 19);

        fll.head.right.right.right = new Node(45);
        fll.head.right.right.right = fll.insert(fll.head.right.right.right, 40);
        fll.head.right.right.right = fll.insert(fll.head.right.right.right, 35);
        fll.head.right.right.right = fll.insert(fll.head.right.right.right, 28);

        fll.head = fll.flatten(fll.head);
        fll.display();

    }

}
