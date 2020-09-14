package com.whf.study.restudy.singleton;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100));

        System.out.println("singleton1 test ====");
        // 测试 singleton1
        threadPoolExecutor.execute(() -> {
            Singleton1 singleton1_1 = Singleton1.getSingleton1();
            System.out.println(singleton1_1);
        });
        threadPoolExecutor.execute(() -> {
            Singleton1 singleton1_2 = Singleton1.getSingleton1();
            System.out.println(singleton1_2);
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("singleton2 test ====");
        // 测试 singleton2
        threadPoolExecutor.execute(() -> {
            Singleton2 singleton2_1 = Singleton2.getSingleton2();
            System.out.println(singleton2_1);
        });
        threadPoolExecutor.execute(() -> {
            Singleton2 singleton2_2 = Singleton2.getSingleton2();
            System.out.println(singleton2_2);
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("singleton3 test ====");
        threadPoolExecutor.execute(()-> {
            Singleton3 singleton3_1 = Singleton3.getSingleton3();
            System.out.println(singleton3_1);
        });

        threadPoolExecutor.execute(()-> {
            Singleton3 singleton3_2 = Singleton3.getSingleton3();
            System.out.println(singleton3_2);
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("singleton4 test ====");
        threadPoolExecutor.execute(()-> {
            Singleton4 singleton4_1 = Singleton4.getSingleton4();
            System.out.println(singleton4_1);
        });
        threadPoolExecutor.execute(()-> {
            Singleton4 singleton4_2 = Singleton4.getSingleton4();
            System.out.println(singleton4_2);
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("singleton5 test ====");
        threadPoolExecutor.execute(()-> {
            Singleton5 singleton5_1 = Singleton5.getSingleton5();
            System.out.println(singleton5_1);
        });
        threadPoolExecutor.execute(()-> {
            Singleton5 singleton5_2 = Singleton5.getSingleton5();
            System.out.println(singleton5_2);
        });


        threadPoolExecutor.shutdown();
    }
}
