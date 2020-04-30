package com.amuse.frameone.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName FutureTaskTest
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/7/30 18:12
 * @Version 1.0
 */
public class FutureTaskTest {

    /**
     * 内部类线程使用方式
     * @param args
     */
    public static void main(String[] args) {
        int j = 2;
        new Thread("线程1"){
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+":"+j);
                }
            }
        }.start();
    }

    /**
     * FutureTask启动线程方式
     * @param args
     */
//    public static void main(String[] args) {
//        FutureTask<String> task = new FutureTask<>(
//                new Callable<String>() {
//                    @Override
//                    public String call() throws Exception {
//                        return "这是返回值";
//                    }
//                }
//        );
//
//        new Thread(task,"其他线程").start();
//
//        try {
//            System.out.println("返回值:"+task.get());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


}
