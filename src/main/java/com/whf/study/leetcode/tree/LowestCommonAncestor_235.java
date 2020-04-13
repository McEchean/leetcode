package com.whf.study.leetcode.tree;

public class LowestCommonAncestor_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        TreeNode max = p.val > q.val ? p : q;
        TreeNode min = p.val > q.val ? q : p;
        if (root.val >= min.val && root.val <= max.val) {
            return root;
        } else if (root.val > max.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
