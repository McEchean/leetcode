package com.whf.study.jzoffer;

import java.util.ArrayList;
import java.util.Arrays;

public class MakeSolution {
    private int allSum;

    public MakeSolution(int allSum) {
        this.allSum = allSum;
    }

    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    public void makeSolution(int sum,int all, int start, int end) {
        //1. 所有最终的总和是 sum
        //2. 一共是 all 个数
        //3. 数字的最大范围是 n
        for (int i = start; i <= end; ++i) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            lists.add(arrayList);
            for (int j = 0; sum - j * i >= 0 && j <= all; ++j) {
                arrayList.add(j);
                System.out.println(j + " 个 " + i + " 块钱");
//                makeSolution(sum - j * i,all - j,i + 1,end);
            }
        }
    }

    public void help(ArrayList<Integer> l, int sum,int all, int i, int end) {
        if(i == end + 1 ) {
            int tmp = 0;
            for (int j = 0; j < l.size(); j++) {
                tmp += l.get(j) * (j + 1);
            }
            if(tmp == this.allSum) {
                System.out.println(l);
            }
//            System.out.println(l);
            return;
        }
        for (int j = 0; sum - j * i >= 0 && j <= all; ++j) {
            ArrayList<Integer> ll = new ArrayList<>(l);
            ll.add(j);
            help(ll,sum - j * i,all - j,i + 1,end);
        }
    }

    public static void main(String[] args) {
        MakeSolution makeSolution = new MakeSolution(220);
        makeSolution.help(new ArrayList<>(),220,40,1,19);
    }
}
