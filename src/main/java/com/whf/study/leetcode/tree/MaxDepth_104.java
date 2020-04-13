package com.whf.study.leetcode.tree;

public class MaxDepth_104 {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left != null || root.right != null) {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        } else {
            return 1;
        }
    }
}
