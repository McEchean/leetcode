package com.whf.study.restudy.other;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;

public class Test2 {

    private static final ArrayBlockingQueue<Long> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        Test2.Producer p = new Test2.Producer("hello");
        Test2.Consumer c1 = new Test2.Consumer("c1");
        Test2.Consumer c2 = new Test2.Consumer("c2");
        Test2.Consumer c3 = new Test2.Consumer("c3");
        Test2.Consumer c4 = new Test2.Consumer("c4");
        Thread pt = new Thread(p);
        Thread c1t = new Thread(c1);
        Thread c2t = new Thread(c2);
        Thread c3t = new Thread(c3);
        Thread c4t = new Thread(c4);
        pt.start();
        c1t.start();
        c2t.start();
        c3t.start();
        c4t.start();
        Thread.sleep(100000);
    }

    public static class Producer implements Runnable {
        private String name;

        public Producer(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            while(true) {
                try {
                    queue.put((new Date()).getTime());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
                try {
                    Long take = queue.take();
                    System.out.println(this.name + " 消费时间：" + take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
