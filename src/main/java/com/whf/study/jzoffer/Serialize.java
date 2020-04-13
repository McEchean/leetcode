package com.whf.study.jzoffer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Serialize {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public String Serialize(TreeNode root) {
        LinkedList<TreeNode> l = new LinkedList<>();
        l.add(root);
        StringBuilder stringBuilder = new StringBuilder();
        while(!l.isEmpty()) {
            int size = l.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = l.poll();
                if(node == null) {
                    stringBuilder.append("#");
                    stringBuilder.append("!");
                    continue;
                }else {
                    stringBuilder.append(node.val);
                    stringBuilder.append("!");
                }
                l.offer(node.left);
                l.offer(node.right);
            }
            stringBuilder.append("|");
        }
        return stringBuilder.toString();
    }
    public TreeNode Deserialize(String str) {
        if(str == null || str.trim().length() == 0) {
            return null;
        }
        ArrayList<LinkedList<TreeNode>> arrayList = new ArrayList<>();

        String[] split = str.split("\\|");
        for (int i = 0; i < split.length; i++) {
            LinkedList<TreeNode> linkedList = new LinkedList<>();
            String[] split1 = split[i].split("!");
            for (int j = 0; j < split1.length; j++) {
                String s = String.valueOf(split1[j]);
                if(!s.equals("#")) {
                    linkedList.offer(new TreeNode(Integer.parseInt(s)));
                } else {
                    linkedList.offer(null);
                }
            }
            arrayList.add(linkedList);
        }
        TreeNode head = null;
        for (int i = 0; i + 1 < arrayList.size(); i++) {
            LinkedList<TreeNode> linkedList = arrayList.get(i);
            int next = 0;
            for (int j = 0; j < linkedList.size(); j++) {
                TreeNode node = linkedList.get(j);
                if(head == null) {
                    head = node;
                }
                if(node == null) {
                    continue;
                } else {
                    node.left = arrayList.get(i + 1).get(next);
                    next ++;
                    node.right = arrayList.get(i + 1).get(next);
                    next ++;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Serialize serialize = new Serialize();

        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        String serialize1 = serialize.Serialize(t1);
        System.out.println(serialize1);
        TreeNode deserialize = serialize.Deserialize(serialize1);
        System.out.println(deserialize);
    }
}
