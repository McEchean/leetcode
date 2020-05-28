package com.whf.study.leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        if(nums == null || nums.length < 4) {
            return null;
        }
        Arrays.sort(nums);

        List<List<Integer>> ls = new ArrayList<>();

        int a,b,c,sum;
        for(int s = 0; s < nums.length - 4; s++) {
            for(a = s + 1; a < nums.length; a++) {
                if(a > s + 1 && nums[a] == nums[a - 1]) {
                    continue;
                }

                b = a + 1;
                c = nums.length - 1;
                while( b < c) {
                    sum = nums[a] + nums[b] + nums[c];

                    if(sum  + nums[s] > target) {
                        c --;
                    } else if (sum  + nums[s] < target) {
                        b ++;
                    } else {
                        ArrayList<Integer> l = new ArrayList<>();
                        l.add(nums[s]);
                        l.add(nums[a]);
                        l.add(nums[b]);
                        l.add(nums[c]);
                        ls.add(l);

                        while((c -= 1) > b && nums[c] == nums[c + 1]) continue;
                        while((b += 1) < c && nums[b] == nums[b - 1]) continue;
                    }
                }
            }
        }
        return ls;
    }

    public static void main(String[] args) {
        Sum4 s = new Sum4();
        List<List<Integer>> lists = s.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(lists);
    }
}
