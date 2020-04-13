package com.whf.study.leetcode.linkedlist;

public class OddEvenList_328 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode startO = head.next;
        ListNode nowJ = head;
        ListNode nowO = head.next;
        ListNode start = head.next.next;
        int count = 2;
        while(start != null) {
            ++count;
            if(count % 2 != 0) {
                //基数
                nowJ.next = start;
                nowJ = start;
            } else {
                //偶数
                nowO.next = start;
                nowO = start;
            }
            start = start.next;
        }
        nowO.next = null;
        nowJ.next = startO;
        return head;
    }
}
