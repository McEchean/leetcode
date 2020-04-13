package com.whf.study.leetcode.tree;

public class MinDepth_111 {
    public int minDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int right = dfs(root.right) + 1;
        int left = dfs(root.left) + 1;
        if(left == 1 && right == 1) {
            return 1;
        }
        if(left == 1 || right == 1) {
            return Math.max(left,right);
        }
        return Math.min(left,right);
    }

}
