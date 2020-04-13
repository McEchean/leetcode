package com.whf.study.jzoffer;

public class ReverseSentence {
    public String ReverseSentence(String str) {
        if(str == null || str.length() <= 1 || str.trim().equals("")) {
            return str;
        }
        String[] s = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length - 1; i >= 0; i--) {
            stringBuilder.append(" ").append(s[i]);
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        ReverseSentence reverseSentence = new ReverseSentence();
        String s = reverseSentence.ReverseSentence("student. a am I");
        System.out.println(s);
    }
}
