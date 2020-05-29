package com.whf.study.leetcode.other;

import java.util.Stack;

public class Parentheses21 {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (st.isEmpty()) {
                st.push(c);
            } else {
                Character character = st.lastElement();
                if ((character == 40 && c == 41) || (character == 123 && c == 125) || (character == 91 && c == 93)) {
                    st.pop();
                } else {
                    st.push(c);
                }
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        Parentheses21 p = new Parentheses21();
        boolean valid = p.isValid("{[]}");
        System.out.println(valid);
    }
}
