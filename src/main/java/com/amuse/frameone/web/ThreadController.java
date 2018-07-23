package com.amuse.frameone.web;

import com.amuse.frameone.service.ThreadService;
import com.amuse.frameone.extend.thread.WorkThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ThreadController
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/7/14 13:52
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/thread")
public class ThreadController {

    @Autowired
    private ThreadService threadService;

    @RequestMapping(value = "/testPools",method = RequestMethod.GET)
    public void testPools(){
        ExecutorService executor = Executors.newFixedThreadPool(10);//线程池10个
        for(int i=0;i<100;i++){//启动100个线程
            WorkThread workThread = new WorkThread(threadService,i,"线程"+i);
            workThread.setName("线程"+i);
            executor.execute(workThread);
        }
    }

}
