package com.whf.study.jzoffer;

import java.util.Arrays;

public class Multiply {
    public int[] multiply(int[] A) {
        int[] b = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int tmp = 1;
            for (int j = 0; j < A.length; j++) {
                if(j == i) {
                    continue;
                } else {
                    tmp *= A[j];
                }
            }
            b[i] = tmp;
        }
        return b;
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        int[] multiply1 = multiply.multiply(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(Arrays.toString(multiply1));
    }
}
