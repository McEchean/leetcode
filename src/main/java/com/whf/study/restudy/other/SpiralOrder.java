package com.whf.study.restudy.other;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> l = new ArrayList<>();
        if(matrix.length == 0 ) {
            return l;
        }
        boolean[][] bm = new boolean[matrix.length][matrix[0].length];
        int all = matrix.length * matrix[0].length;
        int i = 0;
        int j = 0;
        int startI = 0;
        int endI = matrix.length - 1;
        int flagI = 1;
        int startJ = 0;
        int endJ = matrix[0].length - 1;
        int flagJ = 1;
        while (all != 0) {
            // j
            for (; j >= startJ && j <= endJ; ) {
                if (!bm[i][j]) {
                    l.add(matrix[i][j]);
                    bm[i][j] = true;
                    all -= 1;
                }
                j += flagJ;
            }
            if (flagJ > 0) {
                j = endJ;
            } else {
                j = startJ;
            }


            // i
            for (; i >= startI && i <= endI; ) {
                if (!bm[i][j]) {
                    l.add(matrix[i][j]);
                    bm[i][j] = true;
                    all -= 1;
                }
                i += flagI;
            }
            if (flagI > 0) {
                i = endI;
            } else {
                i = startI;
            }

            if (startJ != endJ) {
                if (flagI > 0) {
                    endJ -= 1;
                } else {
                    startJ += 1;
                }
            }

            if (startI != endI) {
                if (flagJ > 0) {
                    startI += 1;
                } else {
                    endI -= 1;
                }
            }

            flagJ = -flagJ;
            flagI = -flagI;
            j += flagJ;
//
//            if(startI == endI && startJ == endJ) {
//                if(!bm[startJ][endJ]) {
//                    l.add(matrix[startJ][endJ]);
//                }
//            }

        }
//        System.out.println(matrix[i][j]);
        return l;
    }

    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        int[][] int1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] int3 = {{1, 2, 3, 4, 5, 6, 7}, {8, 9, 10, 11, 12, 13, 14}, {15, 16, 17, 18, 19, 20, 21}};
        int[][] int2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] int4 = {{1}, {2}, {3}};
        int[][] int5 = {{1,2,3}};
        int[][] int6 = {{}};



        List<Integer> list1 = spiralOrder.spiralOrder(int1);
        System.out.println(list1);

        List<Integer> list2 = spiralOrder.spiralOrder(int2);
        System.out.println(list2);

        List<Integer> list3 = spiralOrder.spiralOrder(int3);
        System.out.println(list3);

        List<Integer> list4 = spiralOrder.spiralOrder(int4);
        System.out.println(list4);

        List<Integer> list5 = spiralOrder.spiralOrder(int5);
        System.out.println(list5);

        List<Integer> list6 = spiralOrder.spiralOrder(int6);
        System.out.println(list6);

    }
}
