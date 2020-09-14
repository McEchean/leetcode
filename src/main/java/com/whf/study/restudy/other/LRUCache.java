package com.whf.study.restudy.other;

import java.util.HashMap;

class LRUCache {

    private int cap;
    private Node head;
    private Node tail;
    private HashMap<Integer,Node> map;

    public class Node {
        private Node pre;
        private Node next;
        private int key;
        private int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public LRUCache(int capacity) {
        this.cap = capacity;
        this.head = null;
        this.tail = null;
        this.map = new HashMap<>();
    }

    public int get(int key) {
//        Node tmp = head;
        Node findNode = map.get(key);
        if(findNode != null) {
            if(findNode != head) {
                Node pre = findNode.pre;
                Node next = findNode.next;


                if(pre != null) {
                    pre.next = next;
                }
                if(next != null) {
                    next.pre = pre;
                }

                findNode.pre = null;
                findNode.next = head;
                head.pre = findNode;
                head = findNode;

                while(tail.next != null) {
                    tail = tail.next;
                }

            }
            return findNode.value;
        }
        return -1;
//        while(tmp != null) {
//            if(tmp.key == key) {
//                // 将这个 tmp 放到首部
//                if(tmp != head) {
//                    Node pre = tmp.pre;
//                    Node next = tmp.next;
//
//
//                    if(pre != null) {
//                        pre.next = next;
//                    }
//                    if(next != null) {
//                        next.pre = pre;
//                    }
//
//                    tmp.pre = null;
//                    tmp.next = head;
//                    head.pre = tmp;
//                    head = tmp;
//
//                    while(tail.next != null) {
//                        tail = tail.next;
//                    }
//
//                }
//                return tmp.value;
//            }
//            tmp = tmp.next;
//        }
//        return -1;
    }

    public void put(int key, int value) {
        if(get(key) == -1) {
            Node newNode = new Node(key, value);
            if(cap > 0) {
                if(head == null && tail == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    head.pre = newNode;
                    newNode.next = head;
                    head = newNode;
                }
                cap -= 1;
            } else {
                // 变更head
                head.pre = newNode;
                newNode.next = head;
                head = newNode;
                // 变更tail
                map.remove(tail.key);
                Node tp = tail.pre;
                if(tp != null) {
                    tp.next = null;
                    tail = tp;
                } else {
                    tail = null;
                }
            }
            map.put(key, newNode);
        } else {
            Node tmp = head;
            while(tmp != null) {
                if(tmp.key == key) {
                    tmp.value = value;
                }
                tmp = tmp.next;
            }
        }

    }

    public static void main(String[] args) {
        LRUCache l = new LRUCache(2);
        l.put(1,1);
        l.put(2,2);
        System.out.println(l.get(1));
        l.put(3,3);
        System.out.println(l.get(2));
        l.put(4,4);
        System.out.println(l.get(1));
        System.out.println(l.get(3));
        System.out.println(l.get(4));


        LRUCache l2 = new LRUCache(2);
        System.out.println(l2.get(2));
        l2.put(2,6);
        System.out.println(l2.get(1));


    }
}
