package com.whf.study.leetcode.tree;

public class LongestUnivaluePath_687 {
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode t) {
        if (t == null || (t.left == null && t.right == null)) {
            return 0;
        }
        int left = dfs(t.left);
        int right = dfs(t.right);
        int arrowLeft = 0, arrowRight = 0;
        if (t.left != null && t.left.val == t.val) {
            arrowLeft += left + 1;
        }
        if (t.right != null && t.right.val == t.val) {
            arrowRight += right + 1;
        }
        max = Math.max(max, arrowLeft + arrowRight);
        return Math.max(arrowLeft,arrowRight);
    }
}
