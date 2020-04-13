package com.whf.study.jzoffer;

public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0) {
            return false;
        }
        return isBFT(sequence,0,sequence.length - 1);
    }

    public boolean isBFT(int[] seq, int start, int end) {
        if(start >= end) {
            return true;
        }
        int val = seq[end];
        int split = start;
        //判断左半边数全部小于根节点，
        for(;split < end && seq[split] < val; split++);
        //判断右半边数全部大于根节点
        for (int i = split; i < end; i++) {
            if(seq[i] < val) {
                return false;
            }
        }
        //继续往下判断的时候记得 end - 1
        return isBFT(seq,start,split - 1) && isBFT(seq,split, end - 1);
    }

}
