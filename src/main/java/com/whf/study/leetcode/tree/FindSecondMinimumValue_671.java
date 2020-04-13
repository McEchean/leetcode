package com.whf.study.leetcode.tree;

public class FindSecondMinimumValue_671 {
    int first = -1;
    int second = -1;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return -1;
        }
        if (first == -1) {
            first = root.val;
        }
        dfs(root.right, first);
        dfs(root.left, first);
        return second;

    }

    private void dfs(TreeNode t, int first) {
        if (t == null) {
            return;
        }
        if (t.val != first) {
            if (second == -1) {
                second = t.val;
            } else if (second > t.val) {
                second = t.val;
            }
        }

        dfs(t.right, first);

        dfs(t.left, first);
    }
}
