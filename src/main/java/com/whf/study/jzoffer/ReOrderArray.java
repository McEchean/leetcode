package com.whf.study.jzoffer;

import java.util.Arrays;

public class ReOrderArray {
    public void reOrderArray(int [] array) {
        int point1 = 0;
        int point2 = array.length - 1;
        int[] a = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 != 0) {
                a[point1] = array[i];
                point1 ++;
            }
        }
        for (int i = array.length - 1; i >= 0 ; i--) {
            if(array[i] % 2 == 0) {
                a[point2] = array[i];
                point2 --;
            }
        }
        for (int i = 0; i < a.length; i++) {
            array[i] = a[i];
        }
    }

    public static void main(String[] args) {
        ReOrderArray reOrderArray = new ReOrderArray();
        int[] array = new int[]{5,6,31,43,5,6,7,83,5,6,7,4,10,12};
        reOrderArray.reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }
}
