package com.whf.study.leetcode.tree;

public class Rob_337 {
    int max = 0;
    public int rob(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode t) {
        if(t == null) {
            return 0;
        }
        if(t.left == null && t.right == null) {
            return t.val;
        }

        if(t.left == null) {
            int tou = t.val + dfs(t.right.left) + dfs(t.right.right);
            int butou = dfs(t.right);
            return Math.max(tou,butou);
        }
        if(t.right == null) {
            int tou = t.val + dfs(t.left.left) + dfs(t.left.right);
            int butou = dfs(t.left);
            return Math.max(tou,butou);
        }
        int tou = t.val + dfs(t.left.left) + dfs(t.left.right) + dfs(t.right.left) + dfs(t.right.right);
        int butou = dfs(t.left) + dfs(t.right);
        return Math.max(tou,butou);
    }
}
