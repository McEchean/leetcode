package com.whf.study.leetcode.linkedlist;


public class AddTwoNumbers_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h = null;
        ListNode head = null;
        int left = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += left;
            left = sum / 10;
            if (h == null) {
                h = new ListNode(sum % 10);
                head = h;
            } else {
                h.next = new ListNode(sum % 10);
                h = h.next;
            }
        }
        if(left != 0) {
            h.next = new ListNode(left);
        }
        return head;
    }
}
