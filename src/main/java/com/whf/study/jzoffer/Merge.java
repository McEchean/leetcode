package com.whf.study.jzoffer;

public class Merge {
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
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode newHead = null;
        ListNode nowHead = null;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                if(nowHead == null) {
                    nowHead = list1;
                } else {
                    nowHead.next = list1;
                    nowHead = nowHead.next;
                }
                list1 = list1.next;
            } else {
                if(nowHead == null) {
                    nowHead = list2;
                } else {
                    nowHead.next = list2;
                    nowHead = list2;
                }
                list2 = list2.next;
            }
            if(newHead == null) {
                newHead = nowHead;
            }
        }
        if(nowHead != null) {
            nowHead.next = list1 == null ? list2 : list1;
        } else {
            newHead = list1 == null ? list2 : list1;
        }
        return newHead;
    }

    /**
     * 别人的代码，思路完全不一样，链表也可以和递归结合
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge1(ListNode list1,ListNode list2) {
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }
        ListNode pMergeHead = null;
        if(list1.val<list2.val){
            pMergeHead = list1;
            pMergeHead.next = Merge1(list1.next,list2);
        }else{
            pMergeHead = list2;
            pMergeHead.next = Merge1(list1,list2.next);
        }
        return pMergeHead;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(12);
        ListNode listNode2 = new ListNode(43);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(23);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(24);
        ListNode listNode7 = new ListNode(6);
        ListNode listNode8 = new ListNode(0);
        listNode1.next = listNode2;
//        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;

        Merge merge = new Merge();
        ListNode merge1 = merge.Merge(listNode1, listNode3);
        System.out.println(merge1);
    }
}
