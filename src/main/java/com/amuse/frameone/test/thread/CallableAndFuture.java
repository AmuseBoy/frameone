package com.amuse.frameone.test.thread;

import java.util.concurrent.*;

/**
 * @ClassName CallableAndFuture
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/7/30 17:42
 * @Version 1.0
 */
public class CallableAndFuture {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(6,10,5,
                TimeUnit.SECONDS,new SynchronousQueue<>());
        //把该线程交由executor执行
        Future<String> future = executor.submit(
                new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        Thread.sleep(2000);
                        return "返回值";
                    }
                }
        );
        System.out.println("等待结果");
        try {
            System.out.println("结果是:"+future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
