package com.whf.study.leetcode.linkedlist;

import java.util.ArrayList;

public class SplitListToParts_725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ls = new ListNode[k];
        if (root == null) {
            return ls;
        }
        ArrayList<ListNode> listNodes = new ArrayList<>();
        while (root != null) {
            listNodes.add(root);
            root = root.next;
        }
        int pn = listNodes.size() / k;
        int ln = listNodes.size() % k;
        int curser = 0;
        for (int i = 0; i < k - 1; i++) {
            if(curser >= listNodes.size()) {
                break;
            }
            ls[i] = listNodes.get(curser);
            if(ln > 0) {
                --ln;
                curser = curser + pn + 1;
            } else {
                curser = curser + pn;
            }
            listNodes.get(curser - 1).next = null;
        }
        if(curser < listNodes.size()) {
            ls[k - 1] = listNodes.get(curser);
        }
        return ls;
    }

}
