package com.amuse.frameone.extend.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName MqHandler
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/7/15 16:35
 * @Version 1.0
 */
@Component
@RabbitListener(queues = "${mq.testQueue}")
public class MqHandler {

    private static final Logger logger = LoggerFactory.getLogger(MqHandler.class);

    @RabbitHandler
    public void TestHandler(String s){
        logger.info("接收-1:"+s);
    }

}
