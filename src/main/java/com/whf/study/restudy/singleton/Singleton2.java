package com.whf.study.restudy.singleton;

/**
 * 单例模式2（懒汉式）：
 * 适用于多线程场景，但是效率不高，因为每次都需要先抢到类对象的锁
 */
public class Singleton2 {
    private static Singleton2 singleton2;

    private Singleton2(){}

    public static synchronized Singleton2 getSingleton2() {
        if(singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}
