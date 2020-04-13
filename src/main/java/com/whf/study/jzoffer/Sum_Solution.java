package com.whf.study.jzoffer;

public class Sum_Solution {
    public int Sum_Solution(int n) {
        //(1 + n) * n / 2;
        int sum = (int)(n + Math.pow(n,2));
        return sum >> 1;
    }
}
