package com.whf.study.jzoffer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Convert {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    ArrayList<TreeNode> list = new ArrayList<>();

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        middleCheck(pRootOfTree);

        return changePoint(list);
    }

    public void middleCheck(TreeNode pRootOfTree) {
        if(pRootOfTree == null) {
            return;
        }
        Convert(pRootOfTree.left);
        list.add(pRootOfTree);
        Convert(pRootOfTree.right);
    }

    public TreeNode changePoint(ArrayList<TreeNode> treeNodes) {
        for (int i = 0; i < treeNodes.size(); i++) {
            if(i != 0) {
                treeNodes.get(i).left = treeNodes.get(i - 1);
            }
            if(i != treeNodes.size() - 1) {
                treeNodes.get(i).right = treeNodes.get(i + 1);
            }
        }
        return treeNodes.get(0);
    }
}

