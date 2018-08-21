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
@RabbitListener(queues = "${mq.topicQueue}")
public class MqHandler2 {

    private static final Logger logger = LoggerFactory.getLogger(MqHandler2.class);

    @RabbitHandler
    public void TestHandler(String s){
        logger.info("接收-2:"+s);
    }
}
