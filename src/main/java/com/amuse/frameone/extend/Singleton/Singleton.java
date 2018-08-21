package com.amuse.frameone.extend.Singleton;

/**
 * @ClassName Singleton
 * @Description 单例模式
 * @Author 刘培振
 * @Date 2018/8/16 10:41
 * @Version 1.0
 */
public class Singleton {

    //volatile防止重排序，可见性
    private volatile static Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    return new Singleton();
                }
            }
        }
        return instance;
    }
}
