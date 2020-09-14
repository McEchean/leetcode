package com.whf.study.restudy.binary;

public class Search {
    public int search(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            if(left == right) {
                return nums[left] == target ? left : -1;
            }

            int mid = (left + right) / 2;

            if(nums[mid] == target) {
                return mid;
            }
            // 判断哪边有序
            if(nums[left] <= nums[mid - 1]) {
                // 左半边有序
                if(nums[mid  - 1] >= target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右半边有序
                if(nums[mid + 1] <= target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search search = new Search();
        int search1 = search.search(new int[]{2,3,4,5,6,7,8,9,1}, 9);
        System.out.println(search1);
    }
}
