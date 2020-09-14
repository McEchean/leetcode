package com.whf.study.restudy.btree;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class LevelOrder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) {
            return res;
        }
        LinkedList<TreeNode> l = new LinkedList<>();
        l.add(root);
        int flag = -1;
        while(l.size() != 0) {
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<TreeNode> t = new ArrayList<>();
            while(l.size() != 0) {
                a.add(l.getFirst().val);
                t.add(l.getFirst());
                l.removeFirst();
            }
            res.add(a);
            for (int i = t.size() - 1; i >= 0; i --) {
                TreeNode treeNode = t.get(i);
                if(flag == 1) {
                    if(treeNode.left != null) {
                        l.add(treeNode.left);
                    }
                    if(treeNode.right != null) {
                        l.add(treeNode.right);
                    }
                } else {
                    if(treeNode.right != null) {
                        l.add(treeNode.right);
                    }
                    if(treeNode.left != null) {
                        l.add(treeNode.left);
                    }
                }
            }

            flag = -flag;
        }
        return res;
    }

    public static void main(String[] args) {
        LevelOrder l = new LevelOrder();
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.right = t5;
        List<List<Integer>> lists = l.levelOrder(t1);
        System.out.println(lists);
    }
}
