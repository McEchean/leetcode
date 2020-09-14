package com.whf.study.restudy.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> s = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        int res = 1;
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int key = nums[i];
            int max = 0;
            while(s.contains(key)) {
                max++;
                key -= 1;
            }
            if(res < max) {
                res = max;
            }
        }
        return res;
    }
}
