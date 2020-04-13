package com.whf.study.leetcode.linkedlist;

/**
 * 双指针法
 *
 * public ListNode removeNthFromEnd(ListNode head, int n) {
 *         // two pointer solution
 *         ListNode dummy = new ListNode(0);
 *         dummy.next = head;
 *         ListNode slow = dummy, fast = dummy;
 *
 *         for (int i = 1; i <= n + 1; i++) {
 *             fast = fast.next;
 *         }
 *
 *         while (fast != null) {
 *             slow = slow.next;
 *             fast = fast.next;
 *         }
 *         slow.next = slow.next.next;
 *         return dummy.next;
 *     }
 */
public class RemoveNthFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode oldHead = head;
        ListNode previous = null;
        ListNode current = head;
        int nn = 1 - n;
        while(head != null) {
            head = head.next;
            nn += 1;
            if(nn > 0) {
                previous = current;
                current = current.next;
            }
        }
        if(nn < 0) {
            return oldHead;
        } else if (nn == 0) {
            return oldHead.next;
        } else {
            previous.next = current.next;
            return oldHead;
        }
    }
}
