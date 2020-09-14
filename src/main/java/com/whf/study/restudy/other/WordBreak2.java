package com.whf.study.restudy.other;

import java.util.*;
import java.util.stream.Collectors;

public class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(!wordBreakDP(s, wordDict)) {
            return new ArrayList<>();
        }

        HashMap<String, Boolean> map = new HashMap<>();
        for(String e: wordDict) {
            map.put(e, true);
        }
        List<List<String>> help = help(s, map);
        List<String> res = new ArrayList<>();

        for (List<String> e: help) {
            StringBuilder o = new StringBuilder();
            for (String i : e) {
                o.append(" ").append(i);
            }
            res.add(o.toString().trim());
        }
        return res;
    }


    private List<List<String>> help(String s, HashMap<String, Boolean> map) {
        List<List<String>>[] rs = new List[s.length() + 1];

        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                String key = s.substring(i, j + 1);
                boolean b = map.containsKey(key);
                if(b) {
                    if(i == 0) {
                        ArrayList<String> l = new ArrayList<>();
                        l.add(s.substring(i,j + 1));
                        List<List<String>> lt = new ArrayList<>();
                        lt.add(l);
                        rs[j] = lt;
                    }

                    if(i - 1 >= 0 && rs[i - 1] != null) {
                        List<List<String>> r = rs[i - 1];
                        List<List<String>> lt = new ArrayList<>();
                        for (List<String> e: r){
                            ArrayList<String> l = new ArrayList<>(e);
                            l.add(s.substring(i,j + 1));
                            lt.add(l);
                        }
                        List<List<String>> r1 = rs[j];
                        if(r1 == null || r1.isEmpty()) {
                            rs[j] = lt;
                        } else {
                            r1.addAll(lt);
                            rs[j] = r1;
                        }
                    }
                }
            }
        }
        return rs[s.length() - 1];
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
        WordBreak2 w = new WordBreak2();
        List<String> pineapplepenapple = w.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Arrays.stream(new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"}).collect(Collectors.toList()));
        System.out.println(pineapplepenapple);
    }
}
