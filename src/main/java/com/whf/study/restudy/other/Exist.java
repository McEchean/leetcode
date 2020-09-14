package com.whf.study.restudy.other;

public class Exist {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0 || word.length() == 0||word.length() > board.length * board[0].length) {
            return false;
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                boolean r = rightFind(board,new boolean[board.length][board[0].length], 0, word, i, j) || leftFind(board,new boolean[board.length][board[0].length],0, word, i, j) ||upFind(board, new boolean[board.length][board[0].length],0, word, i, j) || downFind(board, new boolean[board.length][board[0].length],0, word, i, j);
                if(r) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean rightFind(char[][] board,boolean[][] f, int start, String word, int nowI, int nowJ) {
        if(start == word.length()) {
            return true;
        }
        if(nowJ < board[0].length && board[nowI][nowJ] == word.charAt(start)) {
            if(f[nowI][nowJ]) {
                return false;
            }
            f[nowI][nowJ] = true;
            boolean r = upFind(board, f, 1+start, word, nowI - 1, nowJ) || downFind(board, f, 1+start, word, 1+nowI, nowJ) || rightFind(board,f,  1+start, word, nowI, 1+nowJ);
            if(!r){
                f[nowI][nowJ] = false;
            }
            return r;
        } else {
            return false;
        }
    }

    private boolean leftFind(char[][] board,boolean[][] f,int start, String word, int nowI, int nowJ) {
        if(start == word.length()) {
            return true;
        }
        if(nowJ >= 0 && board[nowI][nowJ] == word.charAt(start)) {
            if(f[nowI][nowJ]) {
                return false;
            }
            f[nowI][nowJ] = true;
            boolean r = upFind(board,f,  1+start, word, nowI - 1, nowJ) || downFind(board,f,  1+start, word, 1+nowI, nowJ) || leftFind(board,f,  1+start, word, nowI, nowJ - 1);
            if(!r){
                f[nowI][nowJ] = false;
            }
            return r;
        } else {
            return false;
        }
    }

    private boolean upFind(char[][] board,boolean[][] f,int start, String word, int nowI, int nowJ) {
        if(start == word.length()) {
            return true;
        }

        if(nowI >= 0 && board[nowI][nowJ] == word.charAt(start)) {
            if(f[nowI][nowJ]) {
                return false;
            }
            f[nowI][nowJ] = true;
            boolean r = upFind(board,f,  1+start, word, nowI - 1, nowJ) || rightFind(board, f, 1+start, word, nowI, 1+nowJ) || leftFind(board,f,  1+start, word, nowI, nowJ - 1);
            if(!r){
                f[nowI][nowJ] = false;
            }
            return r;
        } else {
            return false;
        }
    }

    private boolean downFind(char[][] board,boolean[][] f,int start, String word, int nowI, int nowJ) {
        if(start == word.length()) {
            return true;
        }
        if(nowI < board.length && board[nowI][nowJ] == word.charAt(start)) {
            if(f[nowI][nowJ]) {
                return false;
            }
            f[nowI][nowJ] = true;
            boolean r = downFind(board, f, 1+start, word, nowI + 1, nowJ) || rightFind(board,f,  start + 1, word, nowI, nowJ + 1) || leftFind(board, f, 1+start, word, nowI, nowJ - 1);
            if(!r){
                f[nowI][nowJ] = false;
            }
            return r;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Exist e = new Exist();
        boolean ba = e.exist(new char[][]{{'a', 'b','c','e'},{'s', 'f','e','s'},{'a', 'd','e','e'}}, "abceseeefs");
        System.out.println(ba);
    }
}
