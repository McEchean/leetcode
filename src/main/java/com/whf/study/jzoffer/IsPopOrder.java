package com.whf.study.jzoffer;


import java.util.ArrayList;
import java.util.Arrays;

public class IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int checkPoint = 0;
        int number = pushA.length;

        //从左到右
        for (int i = 0; i < pushA.length; i++) {
            int e = pushA[i];
            if(e == popA[checkPoint]) {
                number --;
                checkPoint ++;
            }
        }
        if(checkPoint == pushA.length) {
            return true;
        }

        for (int i = pushA.length - 1; i >= 0 ; i--) {
            int e = pushA[i];
            if(e == popA[checkPoint]) {
                number--;
                checkPoint ++;
            }
        }
        return number == 0;
    }

    public static void main(String[] args) {
        int[] pushA = new int[]{1,2,3,4,5};
        int[] popA = new int[]{4,3,5,1,2};
        IsPopOrder isPopOrder = new IsPopOrder();
        boolean result = isPopOrder.IsPopOrder(pushA,popA);
        System.out.println(result);
    }
}
