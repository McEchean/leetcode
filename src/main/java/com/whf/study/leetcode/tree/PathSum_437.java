package com.whf.study.leetcode.tree;

public class PathSum_437 {
    int result = 0;
    public int pathSum(TreeNode root, int sum) {
        p(root, sum);
        return result;
    }

    private void p(TreeNode r, int l) {
        dfs(r, l);
        if(r != null) {
            p(r.left, l);
            p(r.right, l);
        }
    }


    private void dfs(TreeNode t, int l) {
        if(t == null) {
            return;
        }
        if(l- t.val == 0) {
            result ++;
        }
        dfs(t.right, l - t.val);
        dfs(t.left, l - t.val);
    }
}
