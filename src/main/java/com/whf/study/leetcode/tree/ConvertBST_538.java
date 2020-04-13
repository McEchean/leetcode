package com.whf.study.leetcode.tree;

import java.util.ArrayList;

public class ConvertBST_538 {
    ArrayList<TreeNode> a = new ArrayList<>();
    public TreeNode convertBST(TreeNode root) {
        inOrder(root);
        for (int i = 0; i < a.size(); i++) {
            int sum = 0;
            for (int j = i; j < a.size(); j++) {
                sum += a.get(j).val;
            }
            a.get(i).val = sum;
        }
        return root;
    }

    private void inOrder(TreeNode t) {
        if(t == null) {
            return;
        }
        inOrder(t.left);
        a.add(t);
        inOrder(t.right);
    }

    /**
     *     public TreeNode convertBST(TreeNode root) {
     *         if (root != null) {
     *             convertBST(root.right);
     *             sum += root.val;
     *             root.val = sum;
     *             convertBST(root.left);
     *         }
     *         return root;
     *     }
     */
}
