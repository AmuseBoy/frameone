package com.amuse.frameone.extend.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyScheduled
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/7/3 15:11
 * @Version 1.0
 */

@Component
public class MyScheduled {

    private final static Logger logger = LoggerFactory.getLogger(MyScheduled.class);

    /**
     * 使用@Async还要使用@EnableAsync
     */
    @Scheduled(cron = "0/20 * * * * ?")
    @Async("asyncTaskExecutor")//也可不设置，会默认使用AsyncTaskExecutor
    public void testMyScheduled(){
        logger.info("定时任务开始(1)............");
        try {
            Thread.sleep(500*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("定时任务结束(1)............");
    }

    @Scheduled(fixedDelay = 1000000)
    public void testMyScheduled2(){
        logger.info("定时任务开始(2)............");
        logger.info("定时任务结束(2)............");
    }


}
