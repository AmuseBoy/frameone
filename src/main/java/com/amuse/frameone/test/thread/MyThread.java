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
        try {
            super.run();
            long beginTime = System.currentTimeMillis();
            int count = 0;
            for(int i = 0; i < 50000000; i ++){
                if(Thread.interrupted()){
                    throw new InterruptedException();
                }
                //Thread.yield();
                count = count + i;
                System.out.println(count);
            }
            long endTiem = System.currentTimeMillis();
            System.out.println("用时:"+(endTiem - beginTime) + "毫秒");
        } catch (InterruptedException e) {
            System.out.println("捕获异常");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            MyThread myThread1 = new MyThread();
            myThread1.start();
            //myThread1.setDaemon(true);
            Thread.sleep(2000);
            myThread1.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main捕获异常");
            e.printStackTrace();
        }
    }
}
