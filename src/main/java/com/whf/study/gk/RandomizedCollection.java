package com.whf.study.gk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

class RandomizedCollection {

    private final LinkedList<Integer> list;
    private final HashMap<Integer, ArrayList<Integer>> m;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.list = new LinkedList<>();
        this.m = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        return !m.containsKey(val);
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        return list.removeFirstOccurrence(new Integer(val));
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int s = list.size();
        if(s == 0) {
            return -1;
        }
        Random random = new Random();
        int index = random.nextInt(s);
        return list.get(index);
    }


    public static void main(String[] args) {
        RandomizedCollection r = new RandomizedCollection();
        r.insert(0);
        r.insert(1);
        r.remove(0);
        r.insert(2);
        r.remove(1);
        int random = r.getRandom();
        System.out.println(random);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
