package com.amuse.frameone.test;

import java.util.concurrent.*;

/**
 * @ClassName ThreadTest
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/7/4 10:26
 * @Version 1.0
 */
public class ThreadTest {

    /**
     * 内部类线程使用方式
     * @param args
     */
//    public static void main(String[] args) {
//        new Thread("线程1"){
//            @Override
//            public void run() {
//                for(int i=0;i<10;i++){
//                    System.out.println(Thread.currentThread().getName()+":"+i);
//                }
//            }
//        }.start();
//    }
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunable());
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(thread);
        System.out.println("跑完了");
    }

}
