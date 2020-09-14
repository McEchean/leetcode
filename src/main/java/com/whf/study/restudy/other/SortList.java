package com.whf.study.restudy.other;

public class SortList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private ListNode h;

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        while (head != null) {
            help(head.val);
            head = head.next;
        }
        return h;
    }

    private void help(int n) {
        ListNode node = new ListNode(n);
        if (h == null) {
            h = node;
            return;
        }
        ListNode tmp = h;
        ListNode last = null;
        while (tmp != null) {
            if (node.val <= tmp.val) {
                node.next = tmp;
                if (last != null) {
                    last.next = node;
                } else {
                    h = node;
                }
                return;
            }
            last = tmp;
            tmp = tmp.next;
        }
        last.next = node;
    }

    public static void main(String[] args) {
        SortList s = new SortList();
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode listNode = s.sortList(l1);
        System.out.println(listNode);
    }
}
