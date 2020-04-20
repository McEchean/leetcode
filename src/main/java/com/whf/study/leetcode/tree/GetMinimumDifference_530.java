package com.whf.study.leetcode.tree;


public class GetMinimumDifference_530 {
    private TreeNode pre;
    private int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root == null) {
            return -1;
        }
        get(root);
        return min;
    }

    private void get(TreeNode t) {
        if(t == null) {
            return;
        }
        get(t.left);
        if(pre != null) {
            min = Math.min(min,t.val - pre.val);
        }
        pre = t;
        get(t.right);
    }
}
