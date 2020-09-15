package com.whf.study.restudy.other;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // find endWord
        boolean flag = false;
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(endWord)) {
                flag = true;
                wordList.remove(i);
            }
        }
        if (!flag) {
            return 0;
        }
        int w = 0;

        for (int i = 0; i < endWord.length(); i++) {

            String pa = endWord.substring(0, i) + "[a-zA-Z]";
            if (i != endWord.length() - 1) {
                pa = pa + endWord.substring(i + 1);
            }
            Pattern p = Pattern.compile(pa);
            Matcher matcher = p.matcher(beginWord);
            if (matcher.find()) {
                return 2;
            }
            for (int q = 0; q < wordList.size(); q++) {
                String f = wordList.get(q);
                Matcher matcher1 = p.matcher(f);
                if (matcher1.find()) {
                    List<String> s = new ArrayList<>();
                    s.addAll(wordList);
                    int last = ladderLength(beginWord, f, s);
                    int newLast = last == 0 ? 0 : last + 1;
                    System.out.println("得到最小 ：" + newLast);

                    if (w != 0 && newLast != 0) {
                        w = Math.min(w, newLast);
                    } else if (w == 0 && newLast != 0) {
                        w = newLast;
                    }
                }
            }
        }
        return w;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs = new HashSet<>(wordList);

        if (!hs.contains(endWord)) {
            return 0;
        }
        ArrayDeque<String> q = new ArrayDeque<>();
        q.push(beginWord);
        HashSet<String> visited = new HashSet<>();
        HashMap<String, Integer> re = new HashMap<>();
        re.put(beginWord, 1);
        visited.add(beginWord);

        while (!q.isEmpty()) {
            String pop = q.getLast();
            for (int i = 0; i < pop.length(); i++) {
                String prefix = pop.substring(0, i);
                String suffix = pop.substring(i + 1);
                List<String> strings = find(prefix, suffix, hs, visited);
                for (String k : strings) {
                    if (k.equals(endWord)) {
                        return re.get(pop) + 1;
                    }
                    q.push(k);
                    re.put(k, 1 + re.get(pop));
                    visited.add(k);
                }
            }
            q.removeLast();
        }
        return 0;
    }

    private List<String> find(String prefix, String suffix, HashSet<String> hs, HashSet<String> visited) {
        ArrayList<String> l = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            String key = prefix + i + suffix;
            if (hs.contains(key) && !visited.contains(key)) {
                l.add(key);
            }
        }
        return l;
    }


    public static void main(String[] args) {
        LadderLength l = new LadderLength();
        String[] ll = new String[]{"hot","cog","dog","tot","hog","hop","pot","dot"};
        List<String> ls = Arrays.stream(ll).collect(Collectors.toList());

        int i = l.ladderLength2("hot", "dog", ls);
        System.out.println(i);
    }
}
