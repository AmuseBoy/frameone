package com.amuse.frameone.test.thread;

import com.amuse.frameone.test.thread.MyRunable;

import java.util.concurrent.*;

/**
 * @ClassName ThreadTest
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/7/4 10:26
 * @Version 1.0
 */
public class ThreadPool {


    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunable());
        ThreadPoolExecutor executor = new ThreadPoolExecutor(6,10,5,
                TimeUnit.SECONDS,new SynchronousQueue<>());
        //ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i=0;i<10;i++){
            executor.execute(thread);
        }
        System.out.println("线程池-1-跑完了");
        //executor.shutdown();
        ThreadPoolExecutor executor1 = new ThreadPoolExecutor(6,10,5,
                TimeUnit.SECONDS,new SynchronousQueue<>());
        for(int i=0;i<10;i++){
            executor1.execute(thread);
        }
        System.out.println("线程池-2-跑完了");
    }

}
