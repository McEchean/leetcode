package com.whf.study.leetcode.other;

public class FindMedianSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        int totalLength = (m + n + 1) >>> 1;
        while(left < right) {
            int i = (left + right) >>> 1;
            int j = totalLength - i;
            if(nums2[j - 1] > nums1[i]) {
                left = i + 1;
            } else {
                right = i;
            }
        }

        int i = left;
        int j = totalLength - left;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];

        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];
        if (((m + n) & 1) == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
        }
    }
}
