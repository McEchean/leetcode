package com.whf.study.leetcode.tree;

import java.util.ArrayList;
import java.util.Comparator;

public class FindTarget_653 {
    ArrayList<Integer> l = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        getVal(root);
        l.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < l.size(); i++) {
            int iv = l.get(i);
            for (int j = i + 1; j < l.size(); j++) {
                int jv = l.get(j);
                if(iv + jv == k) {
                    return true;
                }
            }
        }
        return false;
    }

    private void getVal(TreeNode t) {
        if(t == null) {
            return;
        }
        l.add(t.val);
        getVal(t.right);
        getVal(t.left);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(0);
        TreeNode t2 = new TreeNode(-1);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(-3);
        TreeNode t5 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.right = t5;
        FindTarget_653 f = new FindTarget_653();
        f.findTarget(t1,-4);
    }


}
