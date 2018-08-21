package com.amuse.frameone.extend.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.QueueingConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @ClassName MqHandler
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/7/15 16:35
 * @Version 1.0
 */
@Component
@RabbitListener(queues = "${mq.directQueue}")
public class MqHandler {

    private static final Logger logger = LoggerFactory.getLogger(MqHandler.class);

    @RabbitHandler
    public void TestHandler(String s, Channel channel, Message message){
        logger.info("接收-1:"+s);
        logger.info("{}",message.getBody());

        try {
            logger.info("{}",message.getMessageProperties().getDeliveryTag());
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
