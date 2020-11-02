package com.whf.study.gk;

public class Hello {
    public static void main(String[] args) {
        for(;;) {
            System.out.println("hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
