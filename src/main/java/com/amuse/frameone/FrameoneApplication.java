package com.amuse.frameone;

import com.amuse.frameone.common.util.RedisProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession  //激活redis-session注解，使用redis存储session
@EnableConfigurationProperties(RedisProperties.class)  //激活读取配置注解的注解
@SpringBootApplication
@MapperScan("com.amuse.frameone.dao")
public class FrameoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrameoneApplication.class, args);
	}
}
