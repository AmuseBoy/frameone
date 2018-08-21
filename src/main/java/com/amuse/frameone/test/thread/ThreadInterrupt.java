package com.amuse.frameone.test.thread;

/**
 * @ClassName ThreadInterrupt
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/7/14 10:47
 * @Version 1.0
 */
public class ThreadInterrupt extends Thread{


    @Override
    public void run() {
        try {
            while (true){
                if(this.isInterrupted()){
                    System.out.println("停止了");
                    throw new InterruptedException();
                }
                System.out.println("timer="+System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadInterrupt thread2 = new ThreadInterrupt();
        thread2.start();
        thread2.interrupt();
    }
}
