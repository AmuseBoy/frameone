package com.amuse.frameone.common.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName RedisProperties
 * @Description set方法不要静态的,
 * @Author 刘培振
 * @Date 2018/4/29 14:41
 * @Version 1.0
 */
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {

    private static String host;

    private static int port;

    public static String getHost() {
        return host;
    }

    public void setHost(String host) {
        RedisProperties.host = host;
    }

    public static int getPort() {
        return port;
    }

    public void setPort(int port) {
        RedisProperties.port = port;
    }
}
