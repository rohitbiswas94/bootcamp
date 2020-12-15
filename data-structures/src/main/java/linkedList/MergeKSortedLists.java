package linkedList;

public class MergeKSortedLists {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeLists(lists, 0, lists.length - 1);
    }

    private static ListNode mergeLists(ListNode[] lists, int l, int h) {
        if (l < h) {
            int mid = (l + h) / 2;
            ListNode left = mergeLists(lists, l, mid);
            ListNode right = mergeLists(lists, mid+1, h);
            return merge(left, right);
        }
        return lists[l];
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
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
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] lists = {l1, l2, l3};
        ListNode l4 = mergeKLists(lists);
        display(l4);
    }
}
