package com.whf.study.restudy.singleton;

/**
 * 单例实现1（懒汉式）：
 * 适用于单线程环境
 */
public class Singleton1 {

    private static Singleton1 singleton1;

    private Singleton1(){}

    public static Singleton1 getSingleton1() {
        if(singleton1 == null) {
            singleton1 = new Singleton1();
        }
        return singleton1;
    }
}
