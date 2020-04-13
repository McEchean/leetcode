package com.whf.study.jzoffer;

public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 1) {
            return array[0];
        }
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            int tmpSum = array[i];
            if(tmpSum > max) {
                max = tmpSum;
            }
            for (int j = i + 1; j < array.length; j++) {
                tmpSum += array[j];
                if(tmpSum > max) {
                    max = tmpSum;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        FindGreatestSumOfSubArray findGreatestSumOfSubArray = new FindGreatestSumOfSubArray();
        int i = findGreatestSumOfSubArray.FindGreatestSumOfSubArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5});
        System.out.println(i);
    }
}
