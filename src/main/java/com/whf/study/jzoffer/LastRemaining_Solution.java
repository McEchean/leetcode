package com.whf.study.jzoffer;

import java.util.ArrayList;
import java.util.List;

public class LastRemaining_Solution {
    public int LastRemaining_Solution(int n, int m) {
        int num = n;
        boolean[] bn = new boolean[n];
        int bni = 0;
        for (int i = 0; ;) {
            if(num == 1) {
                return bni;
            }
            if(i == m - 1) {
                bn[bni] = true;
                num -= 1;
                i = -1;
            }
            if(i < m - 1) {
                i++;
                bni++;
                if(bni == n) {
                    bni = 0;
                }
                if(bn[bni]) {
                    while(bn[bni]) {
                        bni += 1;
                        if(bni == n) {
                            bni = 0;
                        }
                    }
                }
            } else {
                i = 0;
            }
        }
    }

    public int LastRemaining_Solution1(int n, int m) {
        if(n<1||m<1){
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        //构建list
        for(int i = 0;i<n;i++){
            list.add(i);
        }
        int cur = -1;
        while(list.size()>1){
            for(int i = 0;i<m;i++){
                cur++;
                if(cur == list.size()){
                    cur = 0;
                }
            }
            list.remove(cur);
            cur--;//cur--的原因，因为新的list中cur指向了下一个元素，为了保证移动m个准确性，所以cur向前移动一位。
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        LastRemaining_Solution lastRemaining_solution = new LastRemaining_Solution();
        int i = lastRemaining_solution.LastRemaining_Solution(7, 2);
        System.out.println(i);
    }
}
