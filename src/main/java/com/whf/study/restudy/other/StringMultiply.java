package com.whf.study.restudy.other;

public class StringMultiply {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String res = "";
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int t1 = num1.charAt(i) - '0';
                int t2 = num2.charAt(j) - '0';
                int tmp = t1 * t2;

                int l1 = num1.length() - 1 - i;
                int l2 = num2.length() - 1 - j;
                String last = "";
                if (res.length() > l1 + l2) {
                    last = res.substring(0, res.length() - (l1 + l2));
                }
                if(l1 + l2 != 0 && "".equals(res)) {
                    for (int k = 0; k < l1 + l2; k++) {
                        res += "0";
                    }
                }
                res = strAdd(last, String.valueOf(tmp)) + res.substring(res.length() - (l1 + l2));
            }
            while (res.startsWith("0")) {
                res = res.substring(1);
            }
        }
        return res;
    }

    private String strAdd(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        if (l1 == 0 && l2 == 0) {
            return "0";
        }
        if (l1 == 0) {
            return num2;
        }
        if (l2 == 0) {
            return num1;
        }
        int last = 0;
        String res = "";
        for (int i = 0; i < Math.min(l1, l2); i++) {
            int i1 = num1.charAt(l1 - 1 - i) - '0';
            int i2 = num2.charAt(l2 - 1 - i) - '0';
            int resI = i1 + i2;
            res = (resI + last) % 10 + res;
            last = (resI + last) / 10;
        }
        String left = "";
        if (l1 > l2) {
            left = num1.substring(0, l1 - l2);
        } else {
            left = num2.substring(0, l2 - l1);
        }
        String s = strAdd(left, String.valueOf(last)) + res;
        return s;
    }

    public static void main(String[] args) {
        StringMultiply stringMultiply = new StringMultiply();
        String multiply = stringMultiply.multiply("140", "721");
        System.out.println(multiply);

        String s = stringMultiply.strAdd("3250908233231", "5");
        System.out.println(s);
    }
}
