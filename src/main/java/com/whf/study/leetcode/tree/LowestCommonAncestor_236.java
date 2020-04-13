package com.whf.study.leetcode.tree;

public class LowestCommonAncestor_236 {
    TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        all(root, p,q);
        return result;
    }

    private void all(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return;
        }
        lowestCommonAncestor(root.left, p, q);
        lowestCommonAncestor(root.right, p, q);
        if (FindP(root, p) && FindQ(root, q)) {
            if (result == null) result = root;
            return;
        }
    }

    private boolean FindP(TreeNode t, TreeNode p) {
        if (t == null) {
            return false;
        }
        if (t == p) {
            return true;
        }
        return FindP(t.left, p) || FindP(t.right, p);
    }

    private boolean FindQ(TreeNode t, TreeNode q) {
        if (t == null) {
            return false;
        }
        if (t == q) {
            return true;
        }
        return FindQ(t.left, q) || FindQ(t.right, q);
    }
}
