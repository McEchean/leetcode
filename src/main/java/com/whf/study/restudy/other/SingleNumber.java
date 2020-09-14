package com.whf.study.restudy.other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Boolean> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            Boolean aBoolean = hashMap.get(nums[i]);
            if(aBoolean == null) {
                hashMap.put(nums[i], true);
            } else {
                hashMap.remove(nums[i]);
            }
        }
        System.out.println(hashMap.size());
        Set<Map.Entry<Integer, Boolean>> entries = hashMap.entrySet();
        for (Map.Entry<Integer, Boolean> entry: entries){
            return entry.getKey();
        }
        return 0;
    }
}
