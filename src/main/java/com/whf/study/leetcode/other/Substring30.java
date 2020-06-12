package com.whf.study.leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Substring30 {
    public List<Integer> findSubstring(String s, String[] words) {
        if(words == null || words.length == 0) {
            return new ArrayList<>();
        }
        int perLength = words[0].length();
        int allLength = words.length * perLength;
        if (allLength > s.length() ) {
            return new ArrayList<>();
        }

        ArrayList<Integer> result = new ArrayList<>();

        Arrays.sort(words);

        for(int i = 0; i + allLength - 1 < s.length(); i ++) {
            ArrayList<String> tmpWords = new ArrayList<>();
            String allWords = s.substring(i, i + allLength);
            for(int j = 0; j < allLength - perLength + 1; j += perLength) {
                String tmpWord = allWords.substring(j, j+ perLength);
                tmpWords.add(tmpWord);
            }
            String[] tmpWordsA = new String[words.length];
            tmpWords.toArray(tmpWordsA);
            Arrays.sort(tmpWordsA);


            boolean flag = true;
            for(int j = 0; j < words.length; j ++) {
                if(!words[j].equals(tmpWordsA[j])) {
                    flag = false;
                }
            }
            if(flag) {
                result.add(i);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Substring30 substring30 = new Substring30();
        List<Integer> barfoothefoobarman = substring30.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
        System.out.println(barfoothefoobarman);
    }
}
