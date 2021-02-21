package com.amuse.frameone.test.thread;

import com.amuse.frameone.test.thread.MyRunable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ThreadTest
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/7/4 10:26
 * @Version 1.0
 */
public class ThreadPool {

    private final static Logger logger = LoggerFactory.getLogger(ThreadPool.class);

    /**
     * 保证单例
     */
    private volatile static ThreadPoolExecutor executor = null;

    //初始化异常处理
    private static MyThreadPoolHandler myThreadPoolHandler = null;

    static {
        myThreadPoolHandler = new MyThreadPoolHandler();
    }

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
            t.setUncaughtExceptionHandler(myThreadPoolHandler);
            t.setName("MyThreadPool-" + t.getName());
            return t;
        }
    }

    /*
     * 异常处理
     */
    private static class MyThreadPoolHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            logger.info("MyThreadPool线程{}异常{}", t.getName(), e);
        }
    }


    /**
     * 测试
     * @param args
     */
//    public static void main(String[] args) {
//        CountDownLatch latch = new CountDownLatch(10);
//        Thread thread = new Thread(new MyRunable(latch));
//        for (int i=0;i<10;i++){
//            ThreadPool.getThreadPool().execute(thread);
//        }
//        try {
//            latch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("所有子线程都跑完了，该跑主线程了");
//    }


    public static void main(String[] args) throws InterruptedException ,ArithmeticException{
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch latch = new CountDownLatch(100000);
        AtomicInteger atomicInteger = new AtomicInteger();
        for(int i = 0 ; i< 100000; i++){
            ThreadPool.getThreadPool().execute(new Thread(){
                @Override
                public void run() {
                    try {
                        //atomicInteger.getAndIncrement();
                        list.add("ass");
                        int ss = 3 /0;
                    }catch (ArithmeticException e){
                        throw e;
                    }finally {
                        latch.countDown();
                    }
                }
            });
        }

        latch.await();
        System.out.println(latch.getCount());
        System.out.println(list.size()+"我去");
        System.out.println(atomicInteger.get());
//        int j = 0;
//        for(int i =0 ;i<20000; i = i +200){
//            int toIndex = i + 200;
//            if(toIndex > list.size()){
//                toIndex = list.size();
//            }
//            if(i< list.size()){
//                list.subList(i, toIndex);
//                j++;
//            }
//        }
//        System.out.println(j);
    }



}
