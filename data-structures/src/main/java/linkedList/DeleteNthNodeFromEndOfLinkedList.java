package linkedList;

public class DeleteNthNodeFromEndOfLinkedList {

    Node head;

    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            next = null;
        }
    }

    private void delete(int n) {
        Node first = head;
        Node second = head;
        for (int i = 1; i <= n; i++) {
            if (second.next == null) {
                if (i == n)
                    head = head.next;
                return;
            }
            second = second.next;
        }

        while (second.next != null) {
            first = first.next;
            second = second.next;
        }

        first.next = first.next.next;
    }

    private void push(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
    }

    private void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + "\t");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        DeleteNthNodeFromEndOfLinkedList obj = new DeleteNthNodeFromEndOfLinkedList();
        obj.push(4);
        obj.push(3);
        obj.push(2);
        obj.push(1);
        obj.delete(2);
        obj.display();
    }
}
