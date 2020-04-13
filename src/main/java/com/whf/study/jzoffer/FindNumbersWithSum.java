package com.whf.study.jzoffer;

import java.util.ArrayList;
import java.util.Arrays;

public class FindNumbersWithSum {

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        //边界条件
        if(array==null||array.length<=1){
            return result;
        }
        int smallIndex=0;
        int bigIndex=array.length-1;
        while(smallIndex<bigIndex){
            //如果相等就放进去
            if((array[smallIndex]+array[bigIndex])==sum){
                result.add(array[smallIndex]);
                result.add(array[bigIndex]);
                //最外层的乘积最小，别被题目误导
                break;
            }else if((array[smallIndex]+array[bigIndex])<sum){
                smallIndex++;
            }else{
                bigIndex--;
            }
        }
        return result;
    }
    public ArrayList<Integer> FindNumbersWithSummy(int [] array, int sum) {
        if(array.length < 2) {
            return null;
        }
        int endIndex = findEndIndex(array, sum);
        for (int i = 0; i <= endIndex; i++) {
            int one = array[i];
            int i1 = Arrays.binarySearch(array, sum - one);
            if(i1 > i && i1 <= endIndex) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                arrayList.add(i1);
                return arrayList;
            }
        }
        return null;
    }


    public int findEndIndex(int[] array, int sum) {
        int start = 0;
        int end = array.length - 1;
        if(array[end] < sum) {
            return end;
        }
        if(array[start] > sum) {
            return start;
        }
        while(true) {
            int mid = (start + end) / 2;
            if(array[mid] < sum && array[mid + 1] > sum) {
                return mid;
            }
            if(array[mid] == sum) {
                while(array[mid - 1] == sum) {
                    mid -= 1;
                }
                return mid;
            } else if(array[mid] > sum) {
                end = mid;
            } else {
                start = mid;
            }
        }
    }

    public static void main(String[] args) {
        FindNumbersWithSum findNumbersWithSum = new FindNumbersWithSum();
        findNumbersWithSum.FindNumbersWithSum(new int[]{4, 5, 6, 7, 9, 13, 34, 56, 67, 68, 69, 97, 100, 123}, 104);

    }
}
