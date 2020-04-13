package com.whf.study.leetcode.tree;

public class InvertTree_226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
