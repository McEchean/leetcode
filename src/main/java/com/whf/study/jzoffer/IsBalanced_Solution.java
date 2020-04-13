package com.whf.study.jzoffer;

public class IsBalanced_Solution {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) {
            return true;
        }
        int lm = getMaxDeep(root.right);
        int rm = getMaxDeep(root.left);
        if(Math.abs(lm - rm) > 1) {
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }


    public int getMaxDeep(TreeNode r) {
        if(r == null) {
            return 0;
        }
        int left = getMaxDeep(r.left);
        int right = getMaxDeep(r.right);
        return 1 + (left > right ? left : right);
    }



    public static void main(String[] args) {
        IsBalanced_Solution isBalanced_solution = new IsBalanced_Solution();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        t5.right = t7;

        boolean b = isBalanced_solution.IsBalanced_Solution(t1);
        System.out.println(b);


    }
}
