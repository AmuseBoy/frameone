package com.amuse.frameone.test.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @ClassName Consumer
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/8/27 11:28
 * @Version 1.0
 */
public class Consumer {

    public static void main(String[] args) {
        try {
            DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("producerGroup");
            consumer.setNamesrvAddr("192.168.32.128:9876");
            //consumer.setInstanceName("Consumer");
            consumer.subscribe("TopicTest1","TagA");
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                    System.out.println(Thread.currentThread().getName()+"MSG:"+list.size());
                    MessageExt messageExt = list.get(0);
                    if(messageExt.getTopic().equals("TopicTest1")){
                        if(messageExt.getTags() != null && messageExt.getTags().equals("TagA")){
                            System.out.println("消息:"+messageExt.getBody());
                        }
                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            consumer.start();

        } catch (MQClientException e) {
            e.printStackTrace();
        }

    }
}
