package com.amuse.frameone.test.thread;

/**
 * @ClassName MyRunable
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/7/5 15:22
 * @Version 1.0
 */
public class MyRunable implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println("线程"+Thread.currentThread().getName()+":执行"+i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunable());
        thread.start();
    }
}
