package com.whf.study.jzoffer;

public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if(str == null) {
            return null;
        }
        int length = str.length();
        if(length == 1 || length == 0) {
            return str;
        }
        int needMove = n % length;
        String rStr = str.substring(0, needMove);
        String lStr = str.substring(needMove,length);
        return lStr + rStr;
    }

    public static void main(String[] args) {
        LeftRotateString leftRotateString = new LeftRotateString();
        String a = leftRotateString.LeftRotateString("abcdefghijklmnopqrst", 4);
        System.out.println(a);
    }
}
