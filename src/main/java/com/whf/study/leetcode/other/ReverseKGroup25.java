package com.whf.study.leetcode.other;

public class ReverseKGroup25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode gard = new ListNode();
        gard.next = head;
        ListNode hh = gard;
        ListNode node = head;
        boolean flag = false;
        while(node != null && !flag) {
            flag = false;
            ListNode f = node;
            for(int i = 0; i < k ; i++) {
                if (f == null) {
                    flag = true;
                    break;
                }
                f = f.next;
            }
            if(!flag) {
                ListNode tmpHead = null;
                ListNode h = null;
                for(int i = 0; i < k ; i++) {
                    if(node == null) {
                        break;
                    }
                    if(i == 0) {
                        tmpHead = node;
                    }
                    ListNode now = node;
                    node = node.next;
                    now.next = h;
                    h = now;
                }
                gard.next = h;
                gard = tmpHead;
            } else {
                gard.next = node;
            }
        }
        return hh.next;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ReverseKGroup25 reverseKGroup25 = new ReverseKGroup25();
        ListNode listNode = reverseKGroup25.reverseKGroup(l1, 3);
        System.out.println(listNode);
    }
}
