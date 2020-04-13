package com.whf.study.jzoffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        TreeSet<ArrayList<Integer>> result = new TreeSet<>(Comparator.comparing(o -> o.get(0)));
        for (int i = 2;(sum / i) >= (i / 2); i++) {

            int start = -1;
            int end = -1;
            int sumTemp = 0;
            if(i % 2 == 0) {
                start = sum / i - (i / 2) + 1;
                end = sum / i + i / 2;
            } else {
                start = sum / i - (i / 2);
                end = sum / i + i / 2;
            }
            if(start == -1 || start == 0 || end == -1) {
                continue;
            }
            ArrayList<Integer> t = new ArrayList<>();
            for (int j = start; j <= end; j++) {
                sumTemp += j;
                t.add(j);
            }
            if(sumTemp == sum) {
                result.add(t);
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        FindContinuousSequence findContinuousSequence = new FindContinuousSequence();
        ArrayList<ArrayList<Integer>> arrayLists = findContinuousSequence.FindContinuousSequence(100);
        for (ArrayList<Integer> a :arrayLists) {
            System.out.println(a);
        }
    }
}
