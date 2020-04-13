package com.whf.study.leetcode.linkedlist;


import java.util.Stack;

/**
 *  注意值传递和引用传递
 *  因为题目要求是O(1)空间复杂度，所以自己写的是不满足要求的
 *
 *  参考答案
 *
 *  public boolean isPalindrome(ListNode head) {
 *     if (head == null || head.next == null) return true;
 *     ListNode slow = head, fast = head.next;
 *     while (fast != null && fast.next != null) {
 *         slow = slow.next;
 *         fast = fast.next.next;           // 两倍速度走，这样可以判断奇偶
 *     }
 *     if (fast != null) slow = slow.next;  // 偶数节点，让 slow 指向下一个节点
 *     cut(head, slow);                     // 切成两个链表
 *     return isEqual(head, reverse(slow));
 * }
 *
 * private void cut(ListNode head, ListNode cutNode) {
 *     while (head.next != cutNode) {
 *         head = head.next;
 *     }
 *     head.next = null;
 * }
 *
 * private ListNode reverse(ListNode head) {
 *     ListNode newHead = null;
 *     while (head != null) {
 *         ListNode nextNode = head.next;
 *         head.next = newHead;
 *         newHead = head;
 *         head = nextNode;
 *     }
 *     return newHead;
 * }
 *
 * private boolean isEqual(ListNode l1, ListNode l2) {
 *     while (l1 != null && l2 != null) {
 *         if (l1.val != l2.val) return false;
 *         l1 = l1.next;
 *         l2 = l2.next;
 *     }
 *     return true;
 * }
 */

public class IsPalindrome_234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }
        ListNode oldHead = head;
        Stack<Integer> a = new Stack<>();
        while(head != null) {
            a.push(head.val);
            head = head.next;
        }
        while(oldHead!= null) {
            Integer pop = a.pop();
            int val = oldHead.val;
            if(val != pop) {
                return false;
            }
            oldHead = oldHead.next;
        }
        return true;
    }

    private ListNode reverse(ListNode h) {
        ListNode t = new ListNode(-1);
        while (h != null) {
            ListNode next = h.next;
            h.next = t.next;
            t.next = h;
            h = next;
        }
        return t.next;
    }
}
