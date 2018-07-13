package com.amuse.frameone.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadTest
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/7/4 10:26
 * @Version 1.0
 */
public class ThreadTest {


    public static void main(String[] args) {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
//                new ArrayBlockingQueue<Runnable>(5));
//
//        for (int i =0 ;i < 15; i++){
//
//        }




        new Thread("线程1"){
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        }.start();





    }
}
