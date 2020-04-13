package com.whf.study.leetcode.linkedlist;

import java.util.ArrayList;


/**
 * 递归
 *
 * public ListNode reverseList(ListNode head) {
 *     if (head == null || head.next == null) {
 *         return head;
 *     }
 *     ListNode next = head.next;
 *     ListNode newHead = reverseList(next);
 *     next.next = head;
 *     head.next = null;
 *     return newHead;
 * }
 *
 * 头插法
 *
 * public ListNode reverseList(ListNode head) {
 *     ListNode newHead = new ListNode(-1);
 *     while (head != null) {
 *         ListNode next = head.next;
 *         head.next = newHead.next;
 *         newHead.next = head;
 *         head = next;
 *     }
 *     return newHead.next;
 * }
 */

public class ReverseList_206 {

    // 头插法
    public ListNode reverseList2(ListNode head) {
        ListNode h = new ListNode(-1);
        ListNode next = head.next;
        h.next = head;
        head.next = null;
        while(next != null) {
            ListNode l = next.next;
            next.next = h.next;
            h.next = next;
            next = l;
        }
        return h.next;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ArrayList<ListNode> listNodes = listNodes2List(head);
        for (int i = listNodes.size() - 1; i > 0; i--) {
            listNodes.get(i).next = listNodes.get(i - 1);
        }
        listNodes.get(0).next = null;
        return listNodes.get(listNodes.size() - 1);
    }

    private ArrayList<ListNode> listNodes2List(ListNode h) {
        ArrayList<ListNode> a = new ArrayList<>();
        while (h != null) {
            a.add(h);
            h = h.next;
        }
        return a;
    }
}
