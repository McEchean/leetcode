package com.whf.study.leetcode.tree;

public class IsBalanced_110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        int i = height(root.left) - height(root.right);
        if(Math.abs(i) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);

    }

    private int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
