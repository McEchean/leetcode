package com.whf.study.leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) {
            return result;
        }
        if(nums.length == 1) {
            List<Integer> l = new ArrayList<>();
            l.add(nums[0]);
            result.add(l);
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
            collect.remove(i);

            int[] newNums = new int[collect.size()];
            for (int j = 0; j < collect.size(); j++) {
                newNums[j] = collect.get(j);
            }
            List<List<Integer>> ft = permute(newNums);
            for(List<Integer> fti : ft) {
                List<Integer> l = new ArrayList<>();
                l.add(nums[i]);
                l.addAll(fti);
                result.add(l);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Permutations_46 p = new Permutations_46();
        List<List<Integer>> permute = p.permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }
}
