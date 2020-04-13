package com.whf.study.jzoffer;

public class IsContinuous {
    public boolean isContinuous(int [] numbers) {
        int[] bucket = new int[14];
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] > 0 && bucket[numbers[i]] > 0) {
                return false;
            }
            bucket[numbers[i]] = bucket[numbers[i]] + 1;
        }
        int all = 5;
        boolean start = false;
        for (int i = 1; i < bucket.length; i++) {
            if(all == 0) {
                return true;
            }
            if(bucket[i] != 0) {
                all -= 1;
                if(!start) {
                    start = true;
                }
                continue;
            }
            if(start) {
                if(bucket[0] > 0) {
                    bucket[0] = bucket[0] - 1;
                    all -= 1;
                    continue;
                }
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsContinuous isContinuous = new IsContinuous();
        boolean continuous = isContinuous.isContinuous(new int[]{1, 3, 0, 0, 5});
        System.out.println(continuous);
    }
}
