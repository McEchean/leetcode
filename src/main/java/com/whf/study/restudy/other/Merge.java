package com.whf.study.restudy.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Merge {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) {
            return intervals;
        }
        TreeMap<Integer,Integer> m = new TreeMap<>();
        for (int[] interval : intervals) {
            int s = interval[0];
            int e = interval[1];
            if (m.containsKey(s)) {
                m.put(s, m.get(s) - 1);
            } else {
                m.put(s, -1);
            }
            if (m.containsKey(e)) {
                m.put(e, m.get(e) + 1);
            } else {
                m.put(e, 1);
            }
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Integer sum = null;
        Integer start = null;

        while(!m.isEmpty()) {
            int v = m.firstEntry().getValue();
            if(v == 0 && start != null) {
                ArrayList<Integer> t = new ArrayList<>();
                t.add(m.firstEntry().getKey());
                t.add(m.firstEntry().getKey());
                res.add(t);
                m.remove(m.firstEntry().getKey());
            } else {
                if(start == null) {
                    start = m.firstEntry().getKey();
                }
                if(sum == null) {
                    sum = m.firstEntry().getValue();
                } else {
                    sum += m.firstEntry().getValue();
                }
                if(sum == 0) {
                    ArrayList<Integer> t = new ArrayList<>();
                    t.add(start);
                    t.add(m.firstEntry().getKey());
                    res.add(t);
                    m.remove(m.firstEntry().getKey());
                    start = null;
                    sum = null;
                } else {
                    m.remove(m.firstEntry().getKey());
                }
            }
        }
        int[][] r = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            r[i] = new int[]{res.get(i).get(0),res.get(i).get(1)};
        }
        return r;
    }

    public static void main(String[] args) {
        Merge m = new Merge();
        m.merge(new int[][]{{1,3},{2,6},{8,10},{16,18}});
    }
}
