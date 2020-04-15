package com.whf.study.leetcode.tree;

public class SortedListToBST_109 {
    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode end = head;
        int count = 0;
        while(end != null) {
            end = end.next;
            count ++;
        }
        ListNode mid = head;
        ListNode preMid = head;
        count = count / 2;
        while(count != 0) {
            preMid = mid;
            mid = mid.next;
            count --;
        }
        preMid.next = null;
        ListNode midNext = mid.next;
        mid.next = null;
        TreeNode midTree = new TreeNode(mid.val);
        midTree.left = sortedListToBST(head);
        midTree.right = sortedListToBST(midNext);
        return midTree;
    }

    public TreeNode sortedListToBST_good(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode root = slow;

        ListNode next = root.next;
        pre.next = null;
        root.next = null;
        TreeNode t = new TreeNode(root.val);
        t.left = sortedListToBST_good(head);
        t.right = sortedListToBST_good(next);
        return t;
    }


    public static void main(String[] args) {
        ListNode t1 = new ListNode(-10);
        ListNode t2 = new ListNode(-3);
        ListNode t3 = new ListNode(0);
        ListNode t4 = new ListNode(5);
        ListNode t5 = new ListNode(9);
        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        t4.next = t5;

        SortedListToBST_109 s = new SortedListToBST_109();
        TreeNode treeNode = s.sortedListToBST_good(t1);
        System.out.println(treeNode);
    }
}
