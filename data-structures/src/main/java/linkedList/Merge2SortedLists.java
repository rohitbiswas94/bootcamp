package linkedList;

class Merge2SortedLists {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (l1 != null && l2 != null) {
            if (l2 == null || (l1 != null && l1.val <= l2.val)) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return head.next;
    }

    private static void display(ListNode l) {
        while (l != null) {
            System.out.print(l.val + "\t");
            l = l.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = mergeTwoLists(l1, l2);
        display(l3);
    }
}
