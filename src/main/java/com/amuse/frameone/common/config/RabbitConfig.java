package com.amuse.frameone.common.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RabbitConfig
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/7/15 15:53
 * @Version 1.0
 */
@Configuration
public class RabbitConfig {

    @Value("${mq.testQueue}")
    private String testQueue;

    /**
     * 注册队列名称
     * @return
     */
    @Bean
    public Queue Queue(){
        return new Queue(testQueue);
    }
}
