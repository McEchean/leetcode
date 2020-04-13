package com.whf.study.leetcode.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        HashSet<Integer> s = new HashSet<>();
        for (int i :nums) {
            if(m.containsKey(i)) {
                m.put(i, m.get(i) + 1);
                s.remove(i);
            } else {
                m.put(i, 1);
                boolean bool = s.add(i);
                // <tt>true</tt> if this set did not already contain the specified
            }
        }
        Iterator<Integer> iterator = s.iterator();
        if(iterator.hasNext()) {
            return iterator.next();
        }
        return 0;

    }
}
