package com.whf.study.leetcode.linkedlist;

public class AddTwoNumbers_445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1r = reverse(l1);
        ListNode l2r = reverse(l2);
        int a = 0;
        ListNode tail = null;
        ListNode start = null;
        while(l1r != null || l2r != null) {
            if(l1r == null) {
                int sum = a + l2r.val;
                ListNode tmp = new ListNode(sum % 10);
                if(tail != null) {
                    tail.next = tmp;
                } else {
                    start = tmp;
                }
                tail = tmp;
                a = sum / 10;
                l2r = l2r.next;
                continue;
            }
            if(l2r == null) {
                int sum = a + l1r.val;
                ListNode tmp = new ListNode(sum % 10);
                if(tail != null) {
                    tail.next = tmp;
                } else {
                    start = tmp;
                }
                tail = tmp;
                a = sum / 10;
                l1r = l1r.next;
                continue;
            }
            int sum = l1r.val + l2r.val + a;
            ListNode tmp = new ListNode(sum % 10);
            if(tail != null) {
                tail.next = tmp;
            } else {
                start = tmp;
            }
            tail = tmp;
            a = sum / 10;
            l1r = l1r.next;
            l2r = l2r.next;
        }
        if(a != 0) {
            ListNode tmp = new ListNode(a);
            tail.next = tmp;
        }
        return reverse(start);
    }

    private ListNode reverse(ListNode h) {
        ListNode tmp = new ListNode(-1);
        while(h != null) {
            ListNode next = h.next;
            h.next = tmp.next;
            tmp.next = h;
            h = next;
        }
        return tmp.next;
    }
}
