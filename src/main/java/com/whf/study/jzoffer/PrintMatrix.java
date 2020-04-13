package com.whf.study.jzoffer;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int allEleNum = matrix.length * matrix[0].length;
        ArrayList<Integer> result = new ArrayList<Integer>(allEleNum);
        while(true) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
                allEleNum --;
            }
            up++;
            if(allEleNum == 0) break;

            for (int i = up; i <= down; i++) {
                result.add(matrix[i][right]);
                allEleNum --;
            }
            right--;
            if(allEleNum == 0) break;

            for (int i = right; i >= left; i--) {
                result.add(matrix[down][i]);
                allEleNum --;
            }
            down--;
            if(allEleNum == 0) break;

            for (int i = down; i >= up; i--) {
                result.add(matrix[i][left]);
                allEleNum --;
            }
            left++;
            if(allEleNum == 0) break;
        }
        return result;
    }

    public static void main(String[] args) {
        PrintMatrix printMatrix = new PrintMatrix();
        int[][] m = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> integers = printMatrix.printMatrix(m);
        System.out.println(integers);
    }
}
