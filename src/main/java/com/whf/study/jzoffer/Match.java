package com.whf.study.jzoffer;

public class Match {
    public boolean match(char[] str, char[] pattern) {
        if(str.length == 0 && pattern.length == 0) {
            return true;
        }
        int strPoint = 0;
        int patternPoint = 0;
        for(;strPoint < str.length && patternPoint < pattern.length;) {
            if(str[strPoint] == pattern[patternPoint]) {
                strPoint += 1;
                patternPoint += 1;
            } else {
                if(pattern[patternPoint] == '.') {
                    strPoint += 1;
                    patternPoint += 1;
                } else if(pattern[patternPoint] == '*') {
                    char perChar = pattern[patternPoint - 1];
                    if(patternPoint + 1 < pattern.length) {
                        patternPoint += 1;
                        while(patternPoint < pattern.length && pattern[patternPoint] == perChar && pattern[patternPoint] != '*') {
                            patternPoint += 1;
                        }
                    }
                    if(str[strPoint] == perChar) {
                        while(strPoint < str.length && str[strPoint] == perChar) {
                            strPoint += 1;
                        }
                    }
                } else if(patternPoint + 1 < pattern.length && pattern[patternPoint + 1] == '*'){
                    patternPoint += 2;
                } else {
                    return false;
                }
            }
        }
        if(strPoint >= str.length && patternPoint >= pattern.length) {
            return true;
        }else {
            return false;
        }
    }

    public boolean match1(char[] str, char[] pattern) {
        return matchStr(str, 0, pattern, 0);
    }

    public boolean matchStr(char[] str, int i, char[] pattern, int j) {

        // 边界
        if (i == str.length && j == pattern.length) { // 字符串和模式串都为空
            return true;
        } else if (j == pattern.length) { // 模式串为空
            return false;
        }

        boolean flag = false;
        boolean next = (j + 1 < pattern.length && pattern[j + 1] == '*'); // 模式串下一个字符是'*'
        if (next) {
            if (i < str.length && (pattern[j] == '.' || str[i] == pattern[j])) { // 要保证i<str.length，否则越界
                return matchStr(str, i, pattern, j + 2) || matchStr(str, i + 1, pattern, j);
            } else {
                return matchStr(str, i, pattern, j + 2);
            }
        } else {
            if (i < str.length && (pattern[j] == '.' || str[i] == pattern[j])) {
                return matchStr(str, i + 1, pattern, j + 1);
            } else {
                return false;
            }
        }
    }


    public static void main(String[] args) {
        Match match = new Match();
        boolean match1 = match.match(new char[]{'a', 'a', 'a'}, new char[]{'a', 'a', '*', 'a'});
        System.out.println(match1);
    }
}
