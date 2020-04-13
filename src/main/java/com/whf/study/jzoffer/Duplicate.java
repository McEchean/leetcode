package com.whf.study.jzoffer;

import java.util.Arrays;

public class Duplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || numbers.length == 0) {
            duplication[0] = -1;
            return false;
        }
        boolean[] bucket = new boolean[length];
        for (int i = 0; i < numbers.length; i++) {
            if(bucket[numbers[i]]) {
                duplication[0] = numbers[i];
                return true;
            } else {
                bucket[numbers[i]] = true;
            }
        }
        duplication[0] = -1;
        return false;
    }

    public static void main(String[] args) {
        Duplicate duplicate = new Duplicate();
        int[] a = new int[1];
        boolean duplicate1 = duplicate.duplicate(new int[]{2, 3, 1, 0, 2, 5, 3}, 7, a);
        System.out.println(duplicate1 + Arrays.toString(a));
    }
}
