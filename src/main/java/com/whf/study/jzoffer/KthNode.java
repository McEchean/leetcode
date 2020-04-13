package com.whf.study.jzoffer;


import java.util.Comparator;
import java.util.TreeSet;

public class KthNode {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public TreeNode KthNode(TreeNode pRoot, int k) {
        if(k == 0 || pRoot == null) {
            return null;
        }
        help(pRoot,k);
        if(set.size() < k) {
            return null;
        }
        return set.pollLast();
    }
    TreeSet<TreeNode> set = new TreeSet<>(new Comparator<TreeNode>() {
        @Override
        public int compare(TreeNode o1, TreeNode o2) {
            return o1.val - o2.val;
        }
    });
    public void help(TreeNode r, int k) {
        if(r != null) {
            if(set.size() < k) {
                set.add(r);
            } else {
                if(set.last().val > r.val) {
                    set.pollLast();
                    set.add(r);
                }
            }
            help(r.left,k);
            help(r.right,k);
        }
    }
}
