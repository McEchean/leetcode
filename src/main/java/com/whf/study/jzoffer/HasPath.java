package com.whf.study.jzoffer;


// todo not pass
public class HasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(matrix.length == 0 || str.length == 0) {
            return false;
        }
        char[][] m = new char[rows][cols];
        int x = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m[i][j] = matrix[x++];
            }
        }
        return false;

    }

    public boolean help(char[][] m, char r) {
        return false;
    }
}
