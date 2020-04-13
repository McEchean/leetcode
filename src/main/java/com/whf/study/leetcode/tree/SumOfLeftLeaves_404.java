package com.whf.study.leetcode.tree;

public class SumOfLeftLeaves_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode t) {
        if(t == null) {
            return 0;
        }
        int val = 0;
        if(t.left != null && t.left.left == null && t.left.right == null) {
            val = t.left.val;
        }
        return val + dfs(t.left) + dfs(t.right);
    }
}
