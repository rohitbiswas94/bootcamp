package linkedList;

public class ReverseNodesKGroup {

    private static ListNode head;

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        int noOfNodes = countNodes(head);
        return reverse(head, k, noOfNodes, 0);
    }

    private static ListNode reverse(ListNode head, int k, int noOfNodes, int nodesTraversed) {
        if (head == null || noOfNodes-nodesTraversed < k) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int count = 0;
        while (count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
            nodesTraversed++;
        }
        if (next != null) {
            head.next = reverse(next, k, noOfNodes, nodesTraversed);
        }
        return prev;
    }

    private static int countNodes(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    private static void push(int data) {
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
    }

    private static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "\t");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        head = new ListNode(9);
        push(8);
        push(7);
        push(6);
        push(5);
        push(4);
        push(3);
        push(2);
        push(1);
        ListNode reverseList = reverseKGroup(head, 3);
        display(reverseList);
    }
}
