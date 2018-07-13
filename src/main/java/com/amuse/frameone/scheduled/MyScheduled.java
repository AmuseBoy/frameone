package com.amuse.frameone.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


    @Scheduled(fixedRate = 1000)
    public void testMyScheduled(){
        logger.info("定时任务开始(1)............");
        logger.info("定时任务结束(1)............");
    }

    @Scheduled(fixedDelay = 1000)
    public void testMyScheduled2(){
        logger.info("定时任务开始(2)............");
        logger.info("定时任务结束(2)............");
    }


}
