package com.whf.study.leetcode.other;

/**
 * 0.去除空格
 * 1.检测符号， 但是只有一个
 * 2.取出数字  直到第一个不是数字的char
 * 3.检测是否溢出
 */
public class Atoi {
    public int myAtoi(String str) {
        // trim space
        str = str.trim();
        if ("".equals(str)) {
            return 0;
        }
        // 检测符号
        long num = 0L;
        int f = 1;
        int first = str.charAt(0);
        if (first - (int)'-' == 0) {
            f = -1;
        } else if (first - (int)'+' == 0) {
            f = 1;
        } else if(first - (int)'0' >= 0 && first - (int)'9' <= 0) {
            num = num * 10 + (first - (int)'0');
        } else {
            return 0;
        }
        for(int i = 1; i < str.length(); i ++) {
            if(num > 2147483647L) {
                break;
            }
            int c = str.charAt(i);
            if(c - (int)'0' >= 0 && c - (int)'9' <= 0) {
                num = num * 10 + (c - (int)'0');
            } else {
                break;
            }
        }
        if(f == -1 && num >= 2147483648L) {
            return -2147483648;
        } else if(num > 2147483647L) {
            return 2147483647;
        }
        return (int)(f * num);
    }
}
