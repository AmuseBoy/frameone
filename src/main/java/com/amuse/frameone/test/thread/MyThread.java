package com.amuse.frameone.test.thread;

/**
 * @ClassName MyThread
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/7/5 15:16
 * @Version 1.0
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread1.start();
        myThread2.start();
    }
}
