package com.whf.study.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal_144 {
    ArrayDeque<TreeNode> q = new ArrayDeque<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ls = new ArrayList<>();
        if (root == null) {
            return ls;
        }
        if (root.left == null && root.right == null) {
            ls.add(root.val);
            return ls;
        }
        q.push(root);
        while (!q.isEmpty()) {
            TreeNode t = q.pop();
            ls.add(t.val);
            TreeNode right = t.right;
            if(right != null) {
                q.push(right);
            }
            TreeNode left = t.left;
            if(left != null) {
                q.push(left);
            }

        }
        return ls;
    }
}
