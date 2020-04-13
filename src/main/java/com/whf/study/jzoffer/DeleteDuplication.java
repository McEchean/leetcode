package com.whf.study.jzoffer;

import java.util.ArrayList;
import java.util.HashMap;

public class DeleteDuplication {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null) {
            return null;
        }
        ArrayList<ListNode> arrayList = new ArrayList<>();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        while(pHead != null) {
            if(hashMap.get(pHead.val) != null) {
                if(hashMap.get(pHead.val) == 1) {
                    arrayList.remove(arrayList.size() - 1);
                    hashMap.put(pHead.val, hashMap.get(pHead.val) + 1);
                }
            } else {
                arrayList.add(pHead);
                hashMap.put(pHead.val,1);
            }
            pHead = pHead.next;
        }
        if(arrayList.size() == 0) {
            return null;
        }
        ListNode head = arrayList.get(0);
        ListNode tail = arrayList.get(0);
        for (int i = 1; i < arrayList.size(); i++) {
            tail.next = arrayList.get(i);
            tail = arrayList.get(i);
        }
        tail.next = null;
        return head;
    }

    public static void main(String[] args) {
        DeleteDuplication deleteDuplication = new DeleteDuplication();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(5);
        ListNode listNode8 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        ListNode listNode = deleteDuplication.deleteDuplication(listNode1);
        System.out.println(listNode);
    }
}
