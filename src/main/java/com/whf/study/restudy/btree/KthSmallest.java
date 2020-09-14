package com.whf.study.restudy.btree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KthSmallest {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int result = 0;
    private boolean flag = false;
    private int kk = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        kk = k;
        result = root.val;
        help(root);
        return result;
    }

    private void help(TreeNode root) {
        if (flag) {
            return;
        }
        if (root == null) {
            return;
        }
        // 二叉搜索树中序遍历就是有序的
        help(root.left);
        this.kk -= 1;
        if (this.kk == 0) {
            result = root.val;
            flag = true;
            return;
        }
        help(root.right);
    }

    public static void main(String[] args) {
        int n = -16;
        n = -n;
        String s = Integer.toBinaryString(n);
        System.out.println(s);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
