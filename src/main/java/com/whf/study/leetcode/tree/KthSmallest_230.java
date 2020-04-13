package com.whf.study.leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthSmallest_230 {
    ArrayList<Integer> a = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        helper(root);
        int[] ints = a.stream().mapToInt(i -> i).toArray();
        Arrays.sort(ints);
        return ints[k - 1];
    }

    private void helper(TreeNode r) {
        if (r == null) {
            return;
        }
        a.add(r.val);
        helper(r.left);
        helper(r.right);
    }
}
