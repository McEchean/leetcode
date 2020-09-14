package com.whf.study.restudy.btree;

import java.util.Arrays;

public class ReConstructTree {
    public class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int v) {
            this.value = v;
        }
    }
    private int nowIndex = 0;

    // 遍历前序顺序的数组，然后在中序里面找到那个数，然后找到进行递归
    public Node reConstruct(int[] head, int[] mid) {
        if (head.length == 0 || mid.length == 0) {
            return null;
        }
        int i = head[nowIndex];
        Node root = new Node(i);
        ++nowIndex;
        int index = -1;
        for (int j = 0; j < mid.length; j++) {
            if (i == mid[j]) {
                index = j;
                break;
            }
        }
        if(index > 0 && index < mid.length - 1) {
            root.left = reConstruct(head, Arrays.copyOfRange(mid, 0, index));
            root.right = reConstruct(head, Arrays.copyOfRange(mid, index + 1, mid.length));
        } else if(index == 0) {
            root.right = reConstruct(head, Arrays.copyOfRange(mid, index + 1, mid.length));
        } else if(index == mid.length - 1) {
            root.left = reConstruct(head, Arrays.copyOfRange(mid, 0, index));
        }
        return root;
    }

    public static void main(String[] args) {
        ReConstructTree reConstructTree = new ReConstructTree();
        int[] head = new int[]{1,2,4,7,3,5,6,8};
        int[] mid = new int[]{4,7,2,1,5,3,8,6};
        Node node = reConstructTree.reConstruct(head, mid);
        System.out.println(node);
    }
}
