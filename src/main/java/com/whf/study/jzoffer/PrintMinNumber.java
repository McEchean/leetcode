package com.whf.study.jzoffer;

import java.util.Arrays;

public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {

        if(numbers == null || numbers.length == 0)return "";
        for(int i=0; i < numbers.length; i++){
            for(int j = i+1; j < numbers.length; j++){
                int sum1 = Integer.valueOf(numbers[i]+""+numbers[j]);
                int sum2 = Integer.valueOf(numbers[j]+""+numbers[i]);
                if(sum1 > sum2){
                    int temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        String str = new String("");
        for(int i=0; i < numbers.length; i++)
            str = str + numbers[i];
        return str;
    }



    public static void main(String[] args) {
        String[] a = new String[]{"321","32","3","328","4"};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
