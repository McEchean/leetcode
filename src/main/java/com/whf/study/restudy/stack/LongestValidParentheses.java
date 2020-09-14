package com.whf.study.restudy.stack;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParenthesesDP(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] dp = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ')') {
                int preIndex = i - dp[i - 1] + 1;
                if(preIndex >= 0 && s.charAt(preIndex) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    // 处理独立的括号对的情形 类似()()、()(())
                    if(preIndex - 1 >= 0) {
                        dp[i] = dp[i] + dp[preIndex - 1];
                    }
                }
            }
        }

        int max = 0;
        for (int value : dp) {
            if (max < value) {
                max = value;
            }
        }

        return max;

    }


    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Character> pStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (pStack.size() == 0) {
                pStack.push(a);
                indexStack.push(i);
                continue;
            }
            if (a == '(') {
                pStack.push(a);
                indexStack.push(i);
            } else {

                if (pStack.lastElement() == '(') {
                    pStack.pop();
                    indexStack.pop();
                } else {
                    pStack.push(')');
                    indexStack.push(i);
                }
            }
        }

        if (indexStack.size() == 0) {
            return s.length();
        }
        int maxlength = 0;
        int lastIndex = s.length();
        while (!indexStack.isEmpty()) {
            int nowIndex = indexStack.pop();
            if (lastIndex - nowIndex - 1 > maxlength) {
                maxlength = lastIndex - nowIndex - 1;
            }
            lastIndex = nowIndex;
        }
        if (lastIndex > maxlength) {
            maxlength = lastIndex;
        }

        return maxlength;


    }

    public static void main(String[] args) {
        LongestValidParentheses s = new LongestValidParentheses();
        int i = s.longestValidParentheses(")()())");
        System.out.println(i);
    }
}
