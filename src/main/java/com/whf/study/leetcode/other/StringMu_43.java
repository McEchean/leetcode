package com.whf.study.leetcode.other;

public class StringMu_43 {

    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String result = "";
        for(int i = num2.length() - 1; i >= 0 ; --i) {
            for(int j = num1.length() - 1; j >= 0 ; --j) {
                int t = num2.charAt(i) - '0';
                int b = num1.charAt(j) - '0';
                int res = t * b;

                // now at j
                int p = 0;
                while (true) {
                    int nowIndex = result.length() - 1 - (num2.length() - 1 - i + num1.length() - 1 - j) - p;

                    if (nowIndex >= 0) {
                        int rt = result.charAt(nowIndex) - '0' + res;
                        int rres = rt % 10;
                        res = rt / 10;
                        result = result.substring(0, nowIndex) + rres  + result.substring(nowIndex + 1);
                    } else {

                        result = res == 0 && p != 0 ? result : res + result;
                        break;
                    }
                    p++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        StringMu_43 stringMu_43 = new StringMu_43();
        String multiply = stringMu_43.multiply("6", "501");
        System.out.println(multiply);
    }
}
