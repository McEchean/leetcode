package com.whf.study.leetcode.other;

public class WildcardMatching_44 {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) {
            return false;
        }
        if(s.length() == 0 && p.length() == 0) {
            return true;
        }

        boolean[][] m = new boolean[s.length() + 1][p.length() + 1];


        for(int i = 0; i < s.length() + 1; ++i) {
            for(int j = 0; j < p.length() + 1; ++j) {
                if(i == 0 && j == 0) {
                    m[i][j] = true;
                    continue;
                }
                if(j == 0 && i != 0) {
                    m[i][j] = false;
                    continue;
                }

                if(i == 0 && j != 0) {
                    if(p.charAt(j - 1) == '*') {
                        m[i][j] = m[i][j - 1];

                    } else {
                        m[i][j] = false;

                    }
                    continue;
                }



                if(p.charAt(j - 1) == s.charAt(i - 1)) {
                    m[i][j] = m[i - 1][j - 1];
                } else {
                    if(p.charAt(j - 1) == '?') {
                        m[i][j] = m[i - 1][j - 1];
                    } else if(p.charAt(j - 1) == '*') {
                        boolean flag = false;
                        for(int ii = i - 1; ii >= 0; ii--) {
                            flag = flag || m[ii][j - 1];
                        }
                        m[i][j] = m[i][j - 1] || m[i - 1][j - 1] || flag;
                    } else {
                        m[i][j] = false;
                    }
                }
            }
        }

        return m[s.length()][p.length()];
    }
}
