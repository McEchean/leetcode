package com.whf.study.jzoffer;

public class ReverseList {
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
                    '}';
        }
    }
    public ListNode ReverseList(ListNode head) {
        if(head == null) {
            return null;
        } else if(head.next == null) {
            return head;
        }
        ListNode n = head.next;
        ListNode nn = n.next;
        head.next = null;
        for(;;) {
            n.next = head;
            head = n;
            n = nn;
            if(n == null) {
                break;
            }
            nn = nn.next;
        }
        return head;
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

        ReverseList reverseList = new ReverseList();
        ListNode listNode = reverseList.ReverseList(listNode7);
        System.out.println(listNode);
    }
}
