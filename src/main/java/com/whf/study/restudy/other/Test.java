package com.whf.study.restudy.other;

import java.util.ArrayDeque;
import java.util.concurrent.ArrayBlockingQueue;

public class Test {
    private static final ArrayBlockingQueue<Integer> pipline = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        Producer p = new Producer("hello");
        Consumer c = new Consumer("c");
        Consumer c1 = new Consumer("c1");
        Thread pt = new Thread(p);
        Thread ct = new Thread(c);
        Thread c1t = new Thread(c1);
        pt.start();
        ct.start();
        c1t.start();
        Thread.sleep(10000);
    }

    public static class Producer implements Runnable {
        private volatile  String name;

        public Producer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while(true) {
                if(pipline.size() < 10) {
                    try {
                        pipline.put(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("满了=====");
                    synchronized (pipline) {
                        pipline.notifyAll();
                        try {
                            pipline.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static class Consumer implements Runnable {
        private String name;

        public Consumer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while(true) {
                if(!pipline.isEmpty()) {
                    try {
                        Integer take = pipline.take();
                        System.out.println("消费：" + take);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    synchronized (pipline) {
                        pipline.notifyAll();
                        try {
                            pipline.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
