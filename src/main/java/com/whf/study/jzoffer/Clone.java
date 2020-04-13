package com.whf.study.jzoffer;

import java.util.HashMap;

public class Clone {
    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) {
            return null;
        }
        if(map.containsKey(pHead)) {
            return map.get(pHead);
        }
        RandomListNode newNode = new RandomListNode(pHead.label);
        map.put(pHead,newNode);
        newNode.next = Clone(pHead.next);
        newNode.random = Clone(pHead.random);
        return newNode;
    }


	public static void main(String[] args) {
		Clone clone = new Clone();
		RandomListNode a = new RandomListNode(1);	
		RandomListNode b = new RandomListNode(2);	
		RandomListNode c = new RandomListNode(3);	
		RandomListNode d = new RandomListNode(4);	
		RandomListNode e = new RandomListNode(5);	
		a.next = b;
		a.random = c;
		b.next = c;
		b.random = e;
		c.next = d;
		d.next = e;
		d.next = b;
			
		RandomListNode r = clone.Clone(a);
		System.out.println(r);
	}	
}
