package com.amuse.frameone.common.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ClassName BookProperties
 * @Description 获取配置文件的几种方式
 * @Author 刘培振
 * @Date 2018/5/28 11:24
 * @Version 1.0
 */
@Component
@PropertySource("classpath:book.properties")
@ConfigurationProperties(prefix = "book")
public class BookProperties {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
