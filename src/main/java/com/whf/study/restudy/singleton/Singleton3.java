package com.whf.study.restudy.singleton;

/**
 * 单例模式3（懒汉式）：
 * 使用多线程场景，并且效率比单例2要高
 * 注意点volatile关键字，防止指令重排，导致可能会因为指令重排非创建实例线程获取到还没有初始化完全的单例示例
 */
public class Singleton3 {
    private static volatile Singleton3 singleton3;

    private Singleton3(){}

    public static Singleton3 getSingleton3() {
        if(singleton3 == null) {
            synchronized (Singleton3.class) {
                if(singleton3 == null) {
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;
    }
}
