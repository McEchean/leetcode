package com.whf.study.restudy.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permute {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        help(new ArrayList<>(), (ArrayList<Integer>) collect);
        return res;
    }

    private void help(ArrayList<Integer> l, ArrayList<Integer> nums) {
        if(nums.size() == 1) {
            l.add(nums.get(0));
            res.add(l);
        }

        for(int i = 0; i < nums.size(); i ++) {
            ArrayList<Integer> lt = new ArrayList<>();
            lt.addAll(l);
            lt.add(nums.get(i));
            ArrayList<Integer> lt1 = new ArrayList<>();
            lt1.addAll(nums);
            lt1.remove(i);
            help(lt, lt1);
        }
    }

    public static void main(String[] args) {
        Permute p = new Permute();
        List<List<Integer>> permute = p.permute(new int[]{1, 2, 3});
        for (List<Integer> list:permute){
            System.out.println(list);

        }
    }
}
