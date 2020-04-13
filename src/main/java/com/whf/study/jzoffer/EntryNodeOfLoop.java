package com.whf.study.jzoffer;

import java.util.HashSet;

public class EntryNodeOfLoop {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead == null) {
            return null;
        }
        HashSet<ListNode> listNodes = new HashSet<>();
        while(pHead.next != null) {
            if(listNodes.contains(pHead)) {
                return pHead;
            }
            listNodes.add(pHead);
            pHead = pHead.next;
        }
        return null;
    }
}
