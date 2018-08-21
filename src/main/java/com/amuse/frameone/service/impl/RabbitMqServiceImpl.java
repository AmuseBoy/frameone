package com.amuse.frameone.service.impl;

import com.amuse.frameone.service.RabbitMqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @ClassName RabbitMqServiceImpl
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/7/15 16:07
 * @Version 1.0
 */
@Service
public class RabbitMqServiceImpl implements RabbitMqService,RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMqServiceImpl.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${mq.directQueue}")
    private String directQueue;

    @Value("${mq.directExchange}")
    private String directExchange;

    @Value("${mq.directRoutingKey}")
    private String directRoutingKey;

    @Value("${mq.topicQueue}")
    private String topicQueue;

    @Value("${mq.topicExchange}")
    private String topicExchange;

    @Value("${mq.topicRoutingKey}")
    private String topicRoutingKey;

    /**
     * 生产者
     */
    public void send() {
        rabbitTemplate.setConfirmCallback(this);
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        logger.info("消息id,{}", correlationData.getId());
        for (int i = 0; i < 100; i++) {
            String context = "Hello" + new Date();
            //rabbitTemplate.convertAndSend(topicExchange,topicRoutingKey,context);
            rabbitTemplate.convertAndSend(directExchange, directRoutingKey, context, correlationData);
            //rabbitTemplate.convertAndSend(testQueue,context);//如果不设置exchange和binding，默认会处理自己
        }
    }



    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        logger.info("确认消息id,{}", correlationData.getId());
        if (ack) {
            logger.info("消息发送确认成功");
        } else {
            logger.info("消息发送确认失败");
        }
    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        logger.info(message.toString()+",i:"+i+",s1:"+s1+",s2:"+s2);
    }
}
