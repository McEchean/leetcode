package com.whf.study.sort;

import java.util.Arrays;

public class Dijkstra {
    public int[] findMinPath(int[][] e,int start, int end) {
        int[] dist = new int[end - start + 1];
        boolean[] book = new boolean[end - start + 1];
        for (int i = start; i <= end; i++) {
            int i1 = e[start][i];
            dist[i - start] = i1;
        }
        book[0] = true;

        while(true) {
            int minIndex = 0;
            while(minIndex < book.length && book[minIndex]) {
                minIndex ++;
            }
            if(minIndex == book.length) {
                break;
            }
            for (int i = 0; i < dist.length; i++) {
                if(dist[i] == Integer.MAX_VALUE || book[i]) {
                    continue;
                }
                if(dist[i] < dist[minIndex]) {
                    minIndex = i;
                }
            }
            book[minIndex] = true;
            for (int i = start; i <= end; i++) {
                int i1 = e[minIndex + start][i];
                if(book[i - start] || i1 == Integer.MAX_VALUE) {
                    continue;
                }
                int tmp = dist[minIndex] + i1;
                if(dist[i - start] > tmp) {
                    dist[i - start] = tmp;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] e = new int[][]{{0,1,12,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,0,9,3,Integer.MAX_VALUE,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,0,Integer.MAX_VALUE,5,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,4,0,13,15},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0,4},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0}};
        Dijkstra dijkstra = new Dijkstra();
        int[] minPath = dijkstra.findMinPath(e, 0, 5);
        System.out.println(Arrays.toString(minPath));

    }
}
