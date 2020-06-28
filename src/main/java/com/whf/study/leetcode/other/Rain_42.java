package com.whf.study.leetcode.other;

import java.util.TreeMap;

public class Rain_42 {


    public int trap(int[] height) {
        int res = 0, mx = 0, n = height.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = mx;
            mx = Math.max(mx, height[i]);
        }
        mx = 0;
        for (int i = n - 1; i >= 0; --i) {
            dp[i] = Math.min(dp[i], mx);
            mx = Math.max(mx, height[i]);
            if (dp[i] - height[i] > 0) res += dp[i] - height[i];
        }
        return res;
    }

//    public int trap(int[] height) {
//        int startTmp = 0;
//        int endTmp = 0;
//        int result = 0;
//        for(;startTmp < height.length;) {
//            int startT = startTmp;
//            if(isStartOrEnd(startTmp, height)) {
//                int sum = 0;
//                for(int j = startTmp + 1; j < height.length; j ++) {
//                    if(isStartOrEnd(j, height)) {
//                        endTmp = j;
//                        int diff = height[startTmp] - height[endTmp];
//                        if(diff > 0) {
//                            for (int i = startTmp + 1; i < endTmp; i++) {
//                                int i1 = height[startTmp] - height[i];
//                                if(diff > i1) {
//                                    sum -= i1;
//                                } else {
//                                    sum = sum - diff;
//                                }
//                            }
//                        }
//                        startTmp = endTmp;
//                        result += sum;
//                        break;
//
//                    } else {
//                        sum = sum + height[startTmp] - height[j];
//                    }
//                }
//            } else {
//                startTmp ++;
//            }
//            if(startT == startTmp) {
//                startTmp ++;
//            }
//
//        }
//        return result;
//    }

//    private boolean isStartOrEnd(int index, int[] height) {
//        if(index >= height.length || index < 0) {
//            return false;
//        }
//        if(index == 0 && (height[index] > height[index + 1])) {
//            return true;
//        } else if(index == 0 && (height[index] <= height[index + 1])) {
//            return false;
//        }
//        if(index == height.length - 1 && height[index] > height[index - 1]) {
//            return true;
//        } else if(index == height.length - 1 && height[index] <= height[index - 1]) {
//            return false;
//        }
//        return height[index] > height[index + 1] && height[index] >= height[index - 1];
//    }

    public static void main(String[] args) {
        Rain_42 r = new Rain_42();
        int trap = r.trap(new int[]{5,2,1,2,1,5});
        System.out.println(trap);
    }
}
