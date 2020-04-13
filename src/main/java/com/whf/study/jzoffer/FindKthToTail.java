package com.whf.study.jzoffer;

import jdk.nashorn.internal.ir.CallNode;

public class FindKthToTail {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k <= 0) {
            return null;
        }
        ListNode nodeK = head;
        ListNode next = head.next;
        while(next != null) {
            if(k > 0) k--;
            if(k == 0) {
                nodeK = nodeK.next;
            }
            next = next.next;
        }
        if(k > 1) return null;
        return nodeK;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;

        FindKthToTail findKthToTail = new FindKthToTail();
        ListNode listNode = findKthToTail.FindKthToTail(listNode1, 9);
        System.out.println(listNode);


    }


}


