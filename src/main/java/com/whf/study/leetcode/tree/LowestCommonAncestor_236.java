package com.whf.study.leetcode.tree;

public class LowestCommonAncestor_236 {
    TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        all(root, p, q);
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

    TreeNode result1 = null;

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        all(root, p, q);
        return result;
    }

    private boolean help(TreeNode t, TreeNode p, TreeNode q) {
        if (t == null) {
            return false;
        }
        int left = help(t.left, p, q) ? 1 : 0;
        int right = help(t.right, p, q) ? 1 : 0;
        int mid = (t == p || t == q) ? 1 : 0;
        if (left + mid + right >= 2) {
            this.result1 = t;
        }
        return left + right + mid > 0;
    }
}
