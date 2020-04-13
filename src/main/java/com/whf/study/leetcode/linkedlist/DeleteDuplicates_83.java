package com.whf.study.leetcode.linkedlist;

public class DeleteDuplicates_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        if(head.val == head.next.val) {
            return deleteDuplicates(head.next);
        }
        head.next = deleteDuplicates(head.next);
        return head;
    }
}
