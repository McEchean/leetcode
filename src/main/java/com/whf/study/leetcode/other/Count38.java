package com.whf.study.leetcode.other;

import java.util.ArrayList;

public class Count38 {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++) {
            String tmp = "";
            for(int index = 0; index < s.length();index++) {
                int count = 1;
                char c = s.charAt(index);
                while(index + 1 < s.length() && s.charAt(index + 1) == c) {
                    index += 1;
                    count++;
                }
                tmp = tmp + Character.forDigit(count,10);
                tmp = tmp + c;
            }
            s = tmp;
        }
        return s;
    }

    public static void main(String[] args) {
        Count38 c =new Count38();
        String s = c.countAndSay(5);
        System.out.println(s);
        ArrayList<Integer> a = new ArrayList<>();

    }
}
