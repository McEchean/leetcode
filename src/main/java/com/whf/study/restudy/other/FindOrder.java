package com.whf.study.restudy.other;


import java.util.*;
import java.util.stream.Collectors;

public class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] start = new int[prerequisites.length];
        for (int i = 0; i < prerequisites.length; i++) {
            start[i] = i;
        }
        return dfs(start, prerequisites,numCourses);
    }

    private int[] dfs(int[] index, int[][] prerequisites, int numCourses) {
        if(index.length == 0) {
            return new int[]{};
        }
        int[] tmp = new int[numCourses];
        Arrays.fill(tmp,-1);
        for(int i = 0; i < index.length;i++) {
            if(tmp[prerequisites[index[i]][0]] == -1){
                tmp[prerequisites[index[i]][0]] = 0;
            }
            if(tmp[prerequisites[index[i]][1]] == -1){
                tmp[prerequisites[index[i]][1]] = 0;
            }
            tmp[prerequisites[index[i]][0]] += 1;
        }
        ArrayList<Integer> l = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < tmp.length; i++) {
            if(tmp[i] == 0) {
                l.add(i);
                for(int j = 0; j < index.length;j++) {
                    if(index[j] != -1 && prerequisites[index[j]][1] == i) {
                        index[j] = -1;
                        count ++;
                    }
                }
            }
        }
        if(count == 0) {
            return new int[]{};
        }
        int[] nextA = new int[count];
        int countn = 0;
        for (int i = 0,j = 0; i < index.length; i++) {
            if(index[i] != -1) {
                nextA[j] = index[i];
                j++;
                countn ++;
            }
        }
        if(countn == 0) {
            nextA = new int[]{};
        }
        int[] dfsa = dfs(nextA, prerequisites, numCourses);

        l.addAll(Arrays.stream(dfsa).boxed().collect(Collectors.toList()));

        int[] res = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            res[i] = l.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        FindOrder findOrder = new FindOrder();
        int[][] p = new int[4][2];
        p[0] = new int[]{1,0};
        p[1] = new int[]{2,0};
        p[2] = new int[]{3,1};
        p[3] = new int[]{3,2};
        int[] order = findOrder.findOrder(4, p);
        System.out.println(Arrays.toString(order));
    }
}
