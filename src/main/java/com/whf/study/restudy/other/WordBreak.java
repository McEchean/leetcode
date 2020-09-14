package com.whf.study.restudy.other;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        for(int i = 0; i < wordDict.size(); i++) {
            String s1 = wordDict.get(i);
            if(s.startsWith(s1) || s.endsWith(s1)) {
                String t = s;
                while(t.startsWith(s1)) {
                    t = t.replaceFirst(s1,"");
                }
                while(t.endsWith(s1)) {
                    t = t.substring(0, t.lastIndexOf(s1));
                }

                if(wordBreak(t, wordDict)) {
                    return true;
                }
            }
            if("".equals(s)) {
                return true;
            }
        }
        return false;

    }

    public boolean wordBreakDP(String s, List<String> wordDict) {
        if(s == null || s.length() ==0 || wordDict == null || wordDict.size() == 0) {
            return false;
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        // dp[i] 表示前i个字母是否在字典中，dp[2] = true 表示前两个字母在字典中，即是substring(0,1)和substring(1,2)
        // 或者substring(0,2)在字典中
        for(int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i ; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak w = new WordBreak();
        boolean cars = w.wordBreak("applepenapple", Arrays.stream(new String[]{"apple","pen"}).collect(Collectors.toList()));
        System.out.println(cars);
    }
}
