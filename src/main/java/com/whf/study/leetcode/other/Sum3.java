package com.whf.study.leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和：
 * 先排序，然后固定一位
 * 再使用两个指针一头一尾，进行判断，若sum > 0, 所以 尾指针向前移， 若 sum < 0 所以头指针向后移
 * 头尾指针移动之后需要进行判断去重，
 */
public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        if(nums == null || nums.length < 3) {
            return ls;
        }
        Arrays.sort(nums);


        int a = 0;
        int b = 0;
        int c = 0;
        int sum = 0;
        for(a = 0;a < nums.length; a ++) {
            if(a > 0 && nums[a] == nums[a - 1])
                continue;
            b = a + 1;
            c = nums.length - 1;
            while(b < c) {
                sum = nums[a] + nums[b] + nums[c];
                if(sum > 0) c --;
                if(sum < 0) b ++;
                if(sum == 0) {

                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(nums[a]);
                    l.add(nums[b]);
                    l.add(nums[c]);
                    ls.add(l);
                    while((b += 1) < c && nums[b] == nums[b - 1])continue;
                    while((c -= 1) > b && nums[c] == nums[c + 1])continue;
                }
            }
        }
        return ls;

    }
}
