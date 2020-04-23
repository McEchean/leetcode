package com.whf.study.leetcode.tree;

public class MapSum_677 {
    private static class Tire {
        int val;
        Tire[] next;
    }
    private Tire[] tires;
    /** Initialize your data structure here. */
    public MapSum_677() {
        this.tires = new Tire[26];
    }

    public void insert(String key, int val) {
        Tire[] ts = this.tires;
        for (int i = 0; i < key.length(); i++) {
            int c = key.charAt(i) - 97;
            Tire t1 = ts[c];
            if (t1 == null) {
                t1 = new Tire();
                t1.next = new Tire[26];
                ts[c] = t1;
                ts = t1.next;

            } else {
                ts = t1.next;
            }
            if(i == key.length() - 1) {
                t1.val = val;
            }
        }
    }

    public int sum(String prefix) {
        int sum = 0;
        Tire[] ts = this.tires;
        for (int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 97;
            if (ts[c] == null) {
                return 0;
            } else {
                if(i == prefix.length() - 1) {
                    sum += ts[c].val;
                }
                ts = ts[c].next;
            }
        }
        sum += sumHelp(ts);
        return sum;
    }

    private int sumHelp(Tire[] ts) {
        int s = 0;
        for (int i = 0; i < 26; i++) {
            Tire t = ts[i];
            if(t != null) {
                s = s + t.val + sumHelp(t.next);
            }
        }
        return s;
    }


    public static void main(String[] args) {
        MapSum_677 s = new MapSum_677();
        s.insert("aa",3);
        int ap = s.sum("a");
        System.out.println(ap);
        s.insert("ab",2);
        int ap1 = s.sum("a");
        System.out.println(ap1);
    }

}
