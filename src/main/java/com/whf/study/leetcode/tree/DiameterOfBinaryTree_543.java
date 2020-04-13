package com.whf.study.leetcode.tree;

public class DiameterOfBinaryTree_543 {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        dfs(root);
        return res;
//        return Math.max(Math.max(dfs(root.left) + dfs(root.right),diameterOfBinaryTree(root.left)),diameterOfBinaryTree(root.right));
    }

    private int dfs(TreeNode t) {
        if(t == null) {
            return 0;
        }
        int left = dfs(t.left) + 1;
        int right = dfs(t.right) + 1;
        res = Math.max(res, left + right);
        return Math.max(left,right);
    }
}
