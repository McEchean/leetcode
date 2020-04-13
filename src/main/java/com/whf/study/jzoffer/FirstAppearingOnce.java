package com.whf.study.jzoffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FirstAppearingOnce {
    ArrayList<Character> pipeline = new ArrayList<>();
    HashMap<Character,Integer> cal = new HashMap<>();
    public void Insert(char ch) {
        if(cal.get(ch) == null) {
            pipeline.add(ch);
            cal.put(ch,1);
        } else {
            if(cal.get(ch) == 1) {
                int i = pipeline.indexOf(ch);
                pipeline.remove(i);
            }
            cal.put(ch, cal.get(ch) + 1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if(pipeline.size() == 0) {
            return '#';
        }
        return pipeline.get(0);
    }


    public static void main(String[] args) {
        FirstAppearingOnce firstAppearingOnce = new FirstAppearingOnce();
        firstAppearingOnce.Insert('g');
        firstAppearingOnce.Insert('o');
        char c = firstAppearingOnce.FirstAppearingOnce();
        System.out.println(c);
        firstAppearingOnce.Insert('o');
        firstAppearingOnce.Insert('g');
        firstAppearingOnce.Insert('l');
        firstAppearingOnce.Insert('e');
        char c2 = firstAppearingOnce.FirstAppearingOnce();
        System.out.println(c2);
    }
}
