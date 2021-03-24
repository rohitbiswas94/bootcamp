package linkedList;

public class ReverseLinkedList {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        return reverseIteration(head);
    }

    private static ListNode reverseIteration(ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head;
        while(currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }

    private static void display(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "\t");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode reverseList = reverseList(head);
        display(reverseList);
    }
}
