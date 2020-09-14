package com.whf.study.restudy.other;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GetIntersectionNode {
    public class ListNode {
        int val;
        ListNode next;


        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int[] a = new int[1];
        List<Integer> collect = Arrays.stream(a).boxed().collect(Collectors.toList());
        // 4,1,8,4,5
        // 5,0,1,8,4,5
        ListNode tmp1 = headA;
        ListNode tmp2 = headB;
        while (!(tmp1 == null || tmp2 == null)) {
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        ListNode startNode = tmp1 == null ? tmp2 : tmp1;
        ListNode nextStart = tmp1 == null ? headB : headA;
        ListNode leftStart = tmp1 == null ? headA : headB;
        while (startNode != null) {
            startNode = startNode.next;
            nextStart = nextStart.next;
        }

        while (leftStart != null && nextStart != null && nextStart != leftStart) {
            leftStart = leftStart.next;
            nextStart = nextStart.next;
        }
        if (leftStart != null || nextStart != null) {
            return leftStart;
        }
        return null;

    }
}
