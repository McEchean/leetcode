package com.whf.study.restudy.singleton;


/**
 * 单例模式5（饿汉式）：
 * 这种方法好处是懒加载，也利用了静态变量只加载一次的特性保证线程安全，但是会多一个类在常量池
 * 注：网上看到有些写法，会在INSTANCE变量前面加上final修饰，这里其实加与不加都是没关系，因为都只会执行一次
 */
public class Singleton5 {

    private Singleton5(){}

    private static class SingletonHolder {
        private static Singleton5 INSTANCE = new Singleton5();
    }

    public static Singleton5 getSingleton5() {
        return SingletonHolder.INSTANCE;
    }

}
