package com.whf.study.jzoffer;

public class StrToInt {
    public int StrToInt(String str) {
        if(str == null) {
            return 0;
        }
        str = str.trim();
        if(str.length() == 0) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        }catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        StrToInt strToInt = new StrToInt();
        int i = strToInt.StrToInt("+239482");
        System.out.println(i);
    }
}
