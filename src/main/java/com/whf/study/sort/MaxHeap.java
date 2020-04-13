package com.whf.study.sort;

import java.util.Arrays;

public class MaxHeap {
    public void init(int[] s) {
        for (int i = 1; i < s.length / 2; i++) {
            build(i,s,s.length - 1);
        }
    }

    public int build(int nodeIndex, int[] s, int lastIndex) {
        int leftNodeIndex = 2 * nodeIndex;
        int rightNodeIndex = 2 * nodeIndex + 1;
        int maxIndex = -1;
        if(leftNodeIndex > lastIndex) {
            //node child
            return s[nodeIndex];
        }
        if(rightNodeIndex > lastIndex) {
            if(s[leftNodeIndex] > s[nodeIndex]) {
                swap(nodeIndex,maxIndex,s);
            }
        } else {
            maxIndex = build(leftNodeIndex,s,lastIndex) > build(rightNodeIndex,s,lastIndex) ? leftNodeIndex : rightNodeIndex;
            if(s[nodeIndex] < s[maxIndex]) {
                swap(nodeIndex,maxIndex,s);
            }
        }
        return s[nodeIndex];
    }

    public void swap(int i, int j, int[] s) {
        int tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }


    public static void main(String[] args) {
        int[] s = new int[]{-1,4,5,7,3,6,8,9,2};
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.init(s);
        System.out.println(Arrays.toString(s));
    }
}
