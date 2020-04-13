package com.whf.study.jzoffer;


import java.util.HashSet;

public class FindFirstCommonNode {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) {
            return null;
        }
        HashSet<ListNode> hashSet = new HashSet<>();
        while(true) {
            if(pHead1 == null && pHead2 == null) {
                return null;
            }
            if(pHead1 != null && hashSet.contains(pHead1)) {
                return pHead1;
            } else {
                hashSet.add(pHead1);
                if(pHead1 != null) {
                    pHead1 = pHead1.next;
                }
            }
            if(pHead2 != null && hashSet.contains(pHead2)) {
                return pHead2;
            } else {
                hashSet.add(pHead2);
                if (pHead2 != null) {
                    pHead2 = pHead2.next;
                }
            }
        }
    }
}
