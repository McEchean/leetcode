package com.whf.study.leetcode.tree;

public class IsSymmetric_101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if(root.left == null || root.right == null) {
            return false;
        }
        if(root.left.val == root.right.val) {
            return left(root.left, root.right);
        }
        return false;
    }

    public boolean left(TreeNode l, TreeNode r) {
        if(l == null && r == null) {
            return true;
        }
        if(l == null || r == null) {
            return false;
        }
        if(l.val == r.val) {
            return left(l.left,r.right) && left(l.right,r.left);
        }
        return false;
    }
}
