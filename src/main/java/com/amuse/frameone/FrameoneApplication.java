package com.amuse.frameone;

import com.amuse.frameone.common.util.RedisProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@EnableConfigurationProperties(RedisProperties.class)  //激活读取配置注解的注解
@SpringBootApplication
@MapperScan("com.amuse.frameone.dao")
public class FrameoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrameoneApplication.class, args);
	}
}
