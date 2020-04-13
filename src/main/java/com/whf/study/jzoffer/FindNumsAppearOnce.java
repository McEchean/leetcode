package com.whf.study.jzoffer;

import java.util.Arrays;

public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Arrays.sort(array);
        boolean n1 = false;
        boolean n2 = false;
        for (int i = 0; ; ) {
            if(n1 && n2) {
                return;
            }
            if(i == array.length - 1) {
                num2[0] = array[i];
                n2 = true;
                i += 1;
                continue;
            }
            if(array[i + 1] - array[i] != 0) {
                if(!n1) {
                    num1[0] = array[i];
                    n1 = true;
                    i += 1;
                    continue;
                }
                num2[0] = array[i];
                n2 = true;
                i += 1;
                continue;
            }
            i += 2;
        }
    }

    public static void main(String[] args) {
        FindNumsAppearOnce findNumsAppearOnce = new FindNumsAppearOnce();
        int[] a = new int[]{2,4,3,6,3,2,5,5};
        findNumsAppearOnce.FindNumsAppearOnce(a,new int[]{1},new int[]{2});
    }
}
