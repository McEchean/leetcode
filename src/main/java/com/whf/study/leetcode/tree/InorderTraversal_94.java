package com.whf.study.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class InorderTraversal_94 {
    ArrayDeque<TreeNode> q = new ArrayDeque<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ls = new ArrayList<>();
        if (root == null) {
            return ls;
        }
        if (root.left == null && root.right == null) {
            ls.add(root.val);
            return ls;
        }
        TreeNode curr = root;
        while (curr != null || !q.isEmpty()) {
            while(curr != null) {
                q.push(curr);
                curr = curr.left;
            }
            curr = q.pop();
            ls.add(curr.val);
            curr = curr.right;
        }
        return ls;
    }
}
