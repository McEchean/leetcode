package com.whf.study.jzoffer;

import java.util.Arrays;

public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        int i = Arrays.binarySearch(array, k);
        if(i < 0) {
            return 0;
        }
        int count = 0;
        for (int j = i; j < array.length && array[j] ==k; j++) {
            count++;
        }
        for (int j = i - 1; j >=0 && array[j] == k ; j--) {
            count++;
        }
        return count;
    }
}
