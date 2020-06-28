package com.whf.study.leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Combination39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (target == 0) {
            ArrayList<Integer> objects = new ArrayList<>();
            res.add(objects);
            return res;
        } else if (target < 0) {
            return null;
        }

        if(candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);


        int candidatesLength = candidates.length;
        for (int i = 0; i < candidatesLength ;i++) {
            int first = target - candidates[i];

            List<List<Integer>> findRes = combinationSum(Arrays.copyOfRange(candidates, i + 1, candidatesLength), first);
            if (findRes == null) {
                continue;
            }
            for (int j = 0; j < findRes.size(); j++) {
                List<Integer> f = findRes.get(j);
                f.add(0, candidates[i]);
                res.add(f);
            }
            while((i + 1) < candidatesLength && candidates[i + 1] == candidates[i]) {
                i+=1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Combination39 combination39 = new Combination39();
        List<List<Integer>> lists = combination39.combinationSum(new int[]{2,5,2,1,2}, 5);
        HashSet<Integer> hashSet = new HashSet<>();
        System.out.println(lists);
    }
}
