package com.amuse.frameone.test.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @ClassName Producer
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/8/22 16:59
 * @Version 1.0
 */
public class Producer {

    public static void main(String[] args) {
        try {
            DefaultMQProducer producer = new DefaultMQProducer("producerGroup");
            producer.setNamesrvAddr("192.168.32.128:9876");
            //producer.setInstanceName("Producer");
            producer.start();

            for(int i=0;i<100;i++){
                {
                    Message message = new Message("TopicTest1",
                            "TagA",
                            "OrderId001",
                            "Hello World".getBytes());
                    SendResult sendResult = producer.send(message);
                    System.out.println(sendResult);
                }

                {
                    Message message = new Message("TopicTest2",
                            "TagB",
                            "OrderId002",
                            "Hello BaiWang".getBytes());
                    SendResult sendResult = producer.send(message);
                    System.out.println(sendResult);
                }
            }
            producer.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
