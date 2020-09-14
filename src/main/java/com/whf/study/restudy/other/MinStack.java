package com.whf.study.restudy.other;

import java.util.Optional;
import java.util.Stack;

class MinStack {

    private Stack<Integer> s;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.s = new Stack<>();
    }

    public void push(int x) {
        this.s.push(x);
    }

    public void pop() {
        this.s.pop();
    }

    public int top() {
        return this.s.lastElement();
    }

    public int getMin() {
        Integer min = s.stream().min(Integer::compareTo).get();
        return min;
    }
}

