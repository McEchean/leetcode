package com.whf.study.jzoffer;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class PrintFromTopToBottom {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    //队列思想

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();

        if(root == null)
            return res;

        deque.add(root);

        while(!deque.isEmpty()){
            TreeNode node = deque.getFirst();
            deque.pollFirst();
            res.add(node.val);

            if(node.left != null)
                deque.addLast(node.left);

            if(node.right != null)
                deque.addLast(node.right);
        }

        return res;
    }
}
