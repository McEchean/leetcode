package com.whf.study.restudy.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Partition {
    private List<List<String>> r = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s.length() == 0) {
            return r;
        }
        if(s.length() == 1) {
            ArrayList<String> l = new ArrayList<>();
            r.add(l);
            return r;
        }
        for(int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if(judge(sub)) {
                ArrayList<String> t = new ArrayList<>();
                t.add(sub);
                help(s.substring(i), t);
            }
        }
        return r;
    }

    private void help(String s, List<String> sl) {
        if(s.length() == 0) {
            r.add(sl);
            return;
        }
        if(s.length() == 1) {
            sl.add(s);
            r.add(sl);
            return;
        }
        if(judge(s)) {
            ArrayList<String> tsl = new ArrayList<>(sl);
            tsl.add(s);
            r.add(tsl);
        }
        for(int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if(judge(sub)) {
                ArrayList<String> tsl = new ArrayList<>(sl);
                tsl.add(sub);
                help(s.substring(i), tsl);
            }
        }
    }

    private boolean judge(String s) {
        return (new StringBuilder(s).reverse()).toString().equals(s);
    }

    public static void main(String[] args) {
        Partition p = new Partition();
        List<List<String>> aabb = p.partition("aabb");
        System.out.println(aabb);
    }
}
