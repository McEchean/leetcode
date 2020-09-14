package com.whf.study.restudy.singleton;

/**
 * 单例模式（饿汉式）：
 * 适用场景多线程，由jvm来保证static的变量只会实例化一次，但是会消耗内存，因为不是按需所取
 */
public class Singleton4 {
    private static Singleton4 singleton4 = new Singleton4();

    private Singleton4() {}

    public static Singleton4 getSingleton4() {
        return singleton4;
    }
}
