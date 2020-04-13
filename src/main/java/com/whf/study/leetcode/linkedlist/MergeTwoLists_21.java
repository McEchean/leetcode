package com.whf.study.leetcode.linkedlist;

public class MergeTwoLists_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        if(l1.val <= l2.val) {
            ListNode l1n = l1.next;
            l1.next = mergeTwoLists(l1n,l2);
            return l1;
        } else {
            ListNode l2n = l2.next;
            l2.next = mergeTwoLists(l1, l2n);
            return l2;
        }
    }
}
