package com.amuse.frameone.service.impl;

import com.amuse.frameone.service.RabbitMqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName RabbitMqServiceImpl
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/7/15 16:07
 * @Version 1.0
 */
@Service
public class RabbitMqServiceImpl implements RabbitMqService {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMqServiceImpl.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${mq.testQueue}")
    private String testQueue;

    /**
     * 生产者
     */
    public void send(){
        for(int i =0 ;i<100;i++){
            String context = "Hello"+new Date();
            rabbitTemplate.convertAndSend(testQueue,context);
        }
    }


}
