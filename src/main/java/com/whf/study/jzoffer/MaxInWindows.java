package com.whf.study.jzoffer;

import com.whf.study.sort.MaxHeap;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxInWindows {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        if(num.length < size || size == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < num.length - size + 1; i++) {
            int[] window = Arrays.copyOfRange(num, i, size + i);
            Arrays.sort(window);
            int max = window[size - 1];
            result.add(max);
        }
        return result;
    }

    public static void main(String[] args) {
        MaxInWindows maxInWindows = new MaxInWindows();
        ArrayList<Integer> arrayList = maxInWindows.maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3);
        System.out.println(arrayList.toString());
    }
}
