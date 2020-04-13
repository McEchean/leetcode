package com.whf.study.jzoffer;

import java.util.ArrayList;

public class TreeDepth {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    int max = 0;
    public int TreeDepth(TreeNode root) {
        //正解
        if(root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return 1 + (left > right ? left : right);
    }

    public void doSearch(ArrayList<TreeNode> queue) {
        //思路是可以的  实现起来  不尽人意
        if(queue.isEmpty()) {
            return;
        }
        TreeNode treeNode = queue.get(0);
        if(treeNode.left != null) {
            treeNode.left.val = treeNode.val + 1;
            queue.add(treeNode.left);
        }
        if(treeNode.right != null) {
            treeNode.right.val = treeNode.val + 1;
            queue.add(treeNode.right);
        }
        queue.remove(treeNode);
        if(treeNode.val > max) {
            max = treeNode.val;
        }
        doSearch(queue);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);
        t1.left = t2;
        t1.right = t3;
        t2.right = t4;
        t2.left = t5;
        t3.right = t6;
        t3.left = t7;
        t4.right = t8;
        t4.left = t9;
        t9.left = t10;
        TreeDepth treeDepth = new TreeDepth();
        int i = treeDepth.TreeDepth(t1);
        System.out.println(i);
    }
}
