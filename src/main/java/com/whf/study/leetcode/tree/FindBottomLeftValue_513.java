package com.whf.study.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class FindBottomLeftValue_513 {
    ArrayDeque<TreeNode> q = new ArrayDeque<>();
    public int findBottomLeftValue(TreeNode root) {
        if(root.left == null && root.right == null) {
            return root.val;
        }
        q.push(root);

        ArrayList<TreeNode> l = new ArrayList<>();
        while(!q.isEmpty()) {
            TreeNode levelTreeNode = null;
            int size = q.size();
            for (int i = 0; i < size && q.size() != 0; i++) {
                TreeNode pop = q.pollLast();
                TreeNode left = pop.left;
                if(left != null) {
                    if(levelTreeNode == null) {
                        levelTreeNode = left;
                    }
                    q.push(left);
                }
                TreeNode right = pop.right;
                if(right != null) {
                    if(levelTreeNode == null) {
                        levelTreeNode = right;
                    }
                    q.push(right);
                }
            }
            if(levelTreeNode != null) {
                l.add(levelTreeNode);
            }
        }
        int size = l.size();
        if(size!= 0) {
            return l.get(size - 1).val;
        }
        return root.val;
    }
}
