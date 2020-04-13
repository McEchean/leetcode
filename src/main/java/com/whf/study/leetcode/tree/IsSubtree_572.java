package com.whf.study.leetcode.tree;

public class IsSubtree_572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traval(s, t);
    }

    public boolean traval(TreeNode s, TreeNode t) {
        return s != null && (equaled(s, t) || traval(s.left, t) || traval(s.right, t));
    }


    public boolean equaled(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && isSubtree(s.left, t.left) && isSubtree(s.right, t.right);
    }
}
