package com.whf.study.jzoffer;

import java.util.Stack;

public class IsSymmetrical {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    public boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null) {
            return true;
        }
        if(pRoot.left == null && pRoot.right == null) {
            return true;
        } else if(pRoot.left != null && pRoot.right != null) {
            l(pRoot.left,-1);
            r(pRoot.right,1);
            if(stack1.size() != stack2.size()) {
                return false;
            }
            while(!stack1.isEmpty()) {
                Integer pop = stack1.pop();
                Integer pop1 = stack2.pop();
                if(pop.compareTo(pop1 * -1) != 0) {
                    return false;
                }
            }
            return true;

        } else {
            return false;
        }
    }

    //遍历

    public void l(TreeNode r, int flag) {
        if(r == null) {
            return;
        }
        stack1.push(r.val * flag);
        l(r.left,-1);
        l(r.right,1);
    }

    public void r(TreeNode r, int flag) {
        if(r == null) {
            return;
        }
        stack2.push(r.val * flag);
        r(r.right, 1);
        r(r.left,-1);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        IsSymmetrical isSymmetrical = new IsSymmetrical();
        isSymmetrical.isSymmetrical(t1);
    }


}
