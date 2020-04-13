package com.whf.study.jzoffer;

import java.util.Comparator;
import java.util.Stack;
import java.util.TreeMap;

public class StackSolution {
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        stack.push(node);
        int index = stack.size() - 1;
        if(minStack.isEmpty()) {
            minStack.push(0);
        } else {
            Integer min = stack.get(minStack.lastElement());
            if(min >= node) {
                minStack.push(index);
            }else {
                minStack.push(minStack.lastElement());
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.lastElement();
    }

    public int min() {
        return stack.get(minStack.lastElement());
    }

    public static void main(String[] args) {
        StackSolution stackSolution = new StackSolution();
        stackSolution.push(3);
        System.out.println(stackSolution.min());
        stackSolution.push(4);
        System.out.println(stackSolution.min());
        stackSolution.push(2);
        System.out.println(stackSolution.min());
        stackSolution.push(3);
        System.out.println(stackSolution.min());
        stackSolution.pop();
        System.out.println(stackSolution.min());
        stackSolution.pop();
        System.out.println(stackSolution.min());
        stackSolution.pop();
        System.out.println(stackSolution.min());
        stackSolution.push(0);
        System.out.println(stackSolution.min());
    }
}
