package com.amuse.frameone.common.config;

import com.amuse.frameone.common.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @ClassName BeanConfig
 * @Description 获取配置文件的几种常用用法
 * @Author 刘培振
 * @Date 2018/5/28 10:53
 * @Version 1.0
 */
@Configuration
@PropertySource("classpath:book.properties")
public class BeanConfig {

//    @Autowired
//    private Environment env;

    /**
     * 使用注入
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "book")
    public Book getBook(){
        return new Book();
    }

//    /**
//     * 使用env
//     * @return
//     */
//    @Bean
//    public Book getBook(){
//        Book book = new Book();
//        book.setId(env.getProperty("book.id"));
//        book.setName(env.getProperty("book.name"));
//        return book;
//    }
}
