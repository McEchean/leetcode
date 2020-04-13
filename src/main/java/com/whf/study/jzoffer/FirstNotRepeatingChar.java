package com.whf.study.jzoffer;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if(str.length() == 0) {
            return -1;
        }
        if(str.length() == 1) {
            return 0;
        }
        HashMap<Character,Integer> notOne = new HashMap<>();
        LinkedHashMap<Character,Integer> one = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(!notOne.containsKey(c)){
                notOne.put(c,1);
                one.put(c,i);
                continue;
            }
            one.remove(c);
        }
        if(one.isEmpty()) {
            return -1;
        }
        return one.entrySet().iterator().next().getValue();
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar firstNotRepeatingChar = new FirstNotRepeatingChar();
        int a = firstNotRepeatingChar.FirstNotRepeatingChar("aaabkbkbshbskodddd");
        System.out.println(a);
    }
}
