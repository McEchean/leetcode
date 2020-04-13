package com.whf.study.jzoffer;

public class HasSubtree {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean judgeSubTree(TreeNode root, TreeNode subTree) {
        if(subTree == null) {
            return true;
        }
        if(root == null) {
            return false;
        }
        if(root.val == subTree.val) {
            return judgeSubTree(root.left,subTree.left) && judgeSubTree(root.right,subTree.right);
        }
        return false;

    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null || root1 == null) {
            return false;
        }
        return judgeSubTree(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }
}
