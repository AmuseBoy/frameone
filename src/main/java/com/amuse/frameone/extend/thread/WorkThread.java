package com.amuse.frameone.extend.thread;

import com.amuse.frameone.service.ThreadService;

/**
 * @ClassName WorkThread
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/7/14 15:57
 * @Version 1.0
 */
public class WorkThread extends Thread {

    private ThreadService threadService;
    private String threadName;
    private int i;

    public WorkThread(ThreadService threadService,int i,String threadName) {
        this.i = i;
        this.threadName = threadName;
        this.threadService = threadService;

    }

    @Override
    public void run() {
        super.run();
        threadService.executeWork(i,threadName);
    }
}
