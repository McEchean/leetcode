package com.whf.study.jzoffer;

import java.math.BigDecimal;

public class IsNumeric {
    public boolean isNumeric(char[] str) {
        try {
            BigDecimal bigDecimal = new BigDecimal(String.valueOf(str));
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
//        for (int i = 0; i < str.length; i++) {
//            if((str[i] == '+' || str[i] == '-') && i != 0) {
//                return false;
//            }
//            if((('a' <= str[i] && str[i] <= 'z') || ('A' <= str[i] && str[i] <= 'Z')) && (str[i] != 'e' || str[i] != 'E')) {
//                return false;
//            }
//
//        }
//
//
//        BigDecimal bigDecimal = new BigDecimal("123a3");
//        System.out.println(bigDecimal);
//        return false;
    }

    public static void main(String[] args) {
        IsNumeric isNumeric = new IsNumeric();
        boolean numeric = isNumeric.isNumeric(new char[]{});
    }
}
