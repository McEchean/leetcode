package com.whf.study.leetcode.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Letter {
    private static HashMap<Integer, String> map = new HashMap<>();
    static {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }
    public List<String> letterCombinations(String digits) {

        if("".equals(digits)) {
            return new ArrayList<>();
        }

        int target = Integer.parseInt(String.valueOf(digits.charAt(0)));
        String ts = map.get(target);
        if(ts == null || "".equals(ts)) {
            return new ArrayList<>();
        }

        ArrayList<String> ls = new ArrayList<>();
        List<String> rls = letterCombinations(digits.substring(1));
        for(int i = 0; i < ts.length(); i++) {
            for(int j = 0; j < rls.size(); j++) {
                ls.add(ts.substring(i,i + 1) + rls.get(j));
            }
            if(rls.size() == 0) {
                ls.add(ts.substring(i,i + 1));
            }
        }
        return ls;
    }


    public static void main(String[] args) {
        Letter l = new Letter();
        List<String> strings = l.letterCombinations("23");
        System.out.println(strings);
    }
}
