package com.whf.study.jzoffer;

import java.util.Arrays;

public class MoreThanHalfNum_Solution {

    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        if(array.length == 1) {
            return array[0];
        }
        Arrays.sort(array);
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength / 2; i++) {
            if(array[i] == array[arrayLength/2 + 1]) {
                return array[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MoreThanHalfNum_Solution moreThanHalfNum_solution = new MoreThanHalfNum_Solution();
        int i = moreThanHalfNum_solution.MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2,4,4,4,4,4,4,4,4});
        System.out.println(i);
    }
}
