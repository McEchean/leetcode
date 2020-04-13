package com.whf.study.jzoffer;

import java.util.ArrayList;

public class FindPath {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null) {
            return result;
        }
        target -= root.val;
        path.add(root.val);
        if(target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        path.remove(path.size() - 1);
        return result;
    }

}
