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

    /**
     * 保证单例
     */
    private volatile static ThreadPoolExecutor executor = null;

    /**
     * 线程池
     * @return
     */
    public static ThreadPoolExecutor getThreadPool() {
        if (null == executor) {
            synchronized (ThreadPool.class){
                if(null == executor){
                    executor = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS,
                            new LinkedBlockingDeque<Runnable>(1024), new ThreadPool.MyThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
                }
            }
        }
        return executor;
    }

    /**
     * 线程工厂
     */
    public static class MyThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName("MyThreadPool-" + t.getName());
            return t;
        }
    }


    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(10);
        Thread thread = new Thread(new MyRunable(latch));
        for (int i=0;i<10;i++){
            ThreadPool.getThreadPool().execute(thread);
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有子线程都跑完了，该跑主线程了");
    }




}
