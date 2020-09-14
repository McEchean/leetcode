package com.whf.study.leetcode.other;

public class JumpGame_45 {

    public int jump(int[] nums) {
        int step = 0;
        for(int i = 0; i < nums.length;) {

            int max = 0;
            int maxIndex = 0;
            for(int j = 1; j <= nums[i]; ++j) {
                // 判断index
                // 当前 i + nums[i + j] + 当前跳的个数j
                if(nums[j + i] + i  + j >= nums.length - 1) {
                    step += 2;
                    return step;
                }
                // 判断最大格数
                // j + nums[i + j]
                if((nums[j + i]  + j) > max) {
                    max = nums[j + i]  + j;
                    maxIndex = j;
                }
            }
            System.out.println(maxIndex);
            i += maxIndex;
            step += 1;
        }
        return step;
    }

    public static void main(String[] args) {
        JumpGame_45 jumpGame_45 = new JumpGame_45();
        int jump = jumpGame_45.jump(new int[]{2,3,1,1,4,3,4,5,6,4,3});
        System.out.println(jump);
    }
}
