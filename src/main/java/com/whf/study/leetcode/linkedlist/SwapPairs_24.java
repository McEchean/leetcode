package com.whf.study.leetcode.linkedlist;

public class SwapPairs_24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode third = head.next.next;

        second.next = first;
        first.next = swapPairs(third);
        return second;
    }
}
