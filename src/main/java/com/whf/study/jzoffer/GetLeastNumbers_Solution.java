package com.whf.study.jzoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k > input.length) {
            return new ArrayList<>();
        }
        Arrays.sort(input);
        int[] ints = Arrays.copyOfRange(input, 0, k);
        ArrayList<Integer> objects = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            objects.add(ints[i]);
        }
        return objects;
    }
}
