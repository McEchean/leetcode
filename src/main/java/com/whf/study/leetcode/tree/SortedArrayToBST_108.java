package com.whf.study.leetcode.tree;

import java.util.Arrays;

public class SortedArrayToBST_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int length = nums.length;
        if(length == 1) {
            return new TreeNode(nums[0]);
        } else if (length == 2) {
            TreeNode s = new TreeNode(nums[0]);
            TreeNode m = new TreeNode(nums[1]);
            m.left = s;
            return m;
        }
        int[] left = Arrays.copyOfRange(nums, 0, length / 2);
        int[] right = Arrays.copyOfRange(nums, length / 2 + 1, length);
        TreeNode mid = new TreeNode(nums[length / 2]);
        mid.left = sortedArrayToBST(left);
        mid.right = sortedArrayToBST(right);
        return mid;
    }
}
