package com.whf.study.restudy.other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class CanFinish {
    HashMap<Integer, Boolean> mb = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 不形成环
        // 有向图
        HashMap<Integer, HashSet<Integer>> m = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++) {
            if(m.containsKey(prerequisites[i][0])) {
                HashSet<Integer> s = m.get(prerequisites[i][0]);
                s.add(prerequisites[i][1]);
            } else {
                HashSet<Integer> s = new HashSet<>();
                s.add(prerequisites[i][1]);
                m.put(prerequisites[i][0], s);
            }

        }
        for(int i = 0; i< numCourses; i++) {
            if(m.containsKey(i)) {
                HashSet<Integer> p = m.get(i);
                HashSet<Integer> hashSet = new HashSet<>();
                hashSet.add(i);
                if(judge(p, m, hashSet)) {
                    return false;
                }
                mb.put(i,false);
            }
        }
        return true;
    }

    private boolean judge(HashSet<Integer> s, HashMap<Integer, HashSet<Integer>> m, HashSet<Integer> target) {
        Iterator<Integer> iterator1 = target.iterator();
        while(iterator1.hasNext()) {
            Integer next = iterator1.next();
            if(s.contains(next)) {
                return true;
            }
        }

        Iterator<Integer> iterator = s.iterator();
        while(iterator.hasNext()) {
            int p = iterator.next();
            if(m.containsKey(p)) {
                target.add(p);
                if(mb.containsKey(p)) {
                } else {
                    if(judge(m.get(p), m, target)) {
                        return true;
                    }
                }
                target.remove(p);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanFinish c = new CanFinish();
        int[][] p = new int[4][2];
        p[0] = new int[]{0,1};
        p[1] = new int[]{3,1};
        p[2] = new int[]{1,3};
        p[3] = new int[]{3,2};
        boolean b = c.canFinish(4, p);
        System.out.println(b);
    }
}
