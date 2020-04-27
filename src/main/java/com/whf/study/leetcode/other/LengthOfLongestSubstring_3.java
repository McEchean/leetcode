package com.whf.study.leetcode.other;

public class LengthOfLongestSubstring_3 {
    private int longest = 1;
    private int[] mem = new int[257];
    private int start = 0;
    public int lengthOfLongestSubstring(String s) {
        if(s == null || "".equals(s)) {
            return 0;
        }
        int length = s.length();
        for(int i = 0; i < length; i++) {
            int c = s.charAt(i);
            if(mem[c] == 0) {
                mem[c] = i + 1;
            } else {
                if(mem[c] > start) {
                    start = mem[c];
                }
                mem[c] = i + 1;
            }
            longest = Math.max(longest, i - start + 1);
        }

        return longest;
    }
}
