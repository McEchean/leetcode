package com.whf.study.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class AverageOfLevel_637 {
    ArrayDeque<TreeNode> q = new ArrayDeque<>();
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> objects = new ArrayList<>();
        if(root == null) {
            return objects;
        }
        q.push(root);
        while(!q.isEmpty()) {
            double a = 0;
            int size = q.size();
            int i = size;
            while(i > 0 && q.size() != 0) {
                TreeNode pop = q.pollLast();
                a += pop.val;
                TreeNode right = pop.right;
                if(right != null) {
                    q.push(right);
                }
                TreeNode left = pop.left;
                if(left != null) {
                    q.push(left);
                }
                i--;
            }
            objects.add(a / size);
        }
        return objects;
    }
}
