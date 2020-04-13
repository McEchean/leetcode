package com.whf.study.jzoffer;

import jdk.nashorn.internal.ir.CallNode;

import java.util.ArrayList;

public class GetUglyNumber_Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index < 7) {
            return index;
        }
        int p1 =0,p2=0,p3=0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        while(arrayList.size() < index) {
            int min = Math.min(Math.min(arrayList.get(p1) * 2, arrayList.get(p2) * 3), arrayList.get(p3) * 5);
            arrayList.add(min);
            if(min == arrayList.get(p1) * 2) {
                p1 += 1;
            }
            if(min == arrayList.get(p2) * 3) {
                p2 += 1;
            }
            if(min == arrayList.get(p3) * 5) {
                p3 += 1;
            }
        }
        return arrayList.get(index - 1);

//
//        if(index == 1) {
//            return 1;
//        }
//        int i = 2;
//        for (;index != 1;i++) {
//            int help2 = help(2, i);
//            if(help2 == 1) {
//                --index;
//                continue;
//            }
//            int help5 = help(5, help2);
//            if(help5 == 1) {
//                --index;
//                continue;
//            }
//            int help3 = help(3, help5);
//            if(help3 == 1) {
//                --index;
//                continue;
//            }
//        }
//        return --i;
    }

    public int help(int k, int number) {
        while((number % k) == 0) {
            number = number / k;
        }
        return number;
    }

    public static void main(String[] args) {
        GetUglyNumber_Solution getUglyNumber_solution = new GetUglyNumber_Solution();
        int i = getUglyNumber_solution.GetUglyNumber_Solution(10);
        System.out.println(i);
    }
}
