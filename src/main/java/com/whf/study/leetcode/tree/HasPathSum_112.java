package com.whf.study.leetcode.tree;

public class HasPathSum_112 {
    boolean result = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return result;
    }

    private void dfs(TreeNode r,int left) {
        if(r == null) {
            return;
        }
        if(r.left == null && r.right == null) {
            if(left - r.val == 0) {
                result = true;
            }
        }
        dfs(r.left, left - r.val);
        dfs(r.right, left - r.val);
    }
}
