package com.amuse.frameone.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName Book2Properties
 * @Description 获取配置文件信息的方式,静态方式，需要配置@EnableConfigurationProperties
 * @Author 刘培振
 * @Date 2018/5/28 11:07
 * @Version 1.0
 */
@PropertySource("classpath:book.properties")
@ConfigurationProperties(prefix = "book")
public class BookStaticProperties {
    private static String id;
    private static String name;

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        BookStaticProperties.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        BookStaticProperties.name = name;
    }
}
