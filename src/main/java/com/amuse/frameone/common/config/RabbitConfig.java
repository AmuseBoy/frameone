package com.amuse.frameone.common.config;

import org.springframework.amqp.core.*;
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
     * direct示例
     * 注册队列名称
     * 如果不设置exchange和binding，默认会处理自己
     * @return
     */
    @Bean
    public Queue directQueue(){
        return new Queue(directQueue);
    }

    /**
     * direct
     * @return
     */
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(directExchange);
    }

    @Bean
    public Binding directBinding(Queue directQueue,DirectExchange directExchange){
        return BindingBuilder.bind(directQueue).to(directExchange).with(directRoutingKey);
    }


    /**
     * topic示例
     * @return
     */
    @Bean
    public Queue topicQueue(){
        return new Queue(topicQueue);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(topicExchange);
    }

    @Bean
    public Binding topicBinding(Queue topicQueue,TopicExchange topicExchange){
        return BindingBuilder.bind(topicQueue).to(topicExchange).with(topicRoutingKey);
    }

}
