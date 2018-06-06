package com.amuse.frameone;

import com.amuse.frameone.common.model.BookStaticProperties;
import com.amuse.frameone.common.model.RedisProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60)  //激活redis-session注解，使用redis存储session  设置session有效期
@EnableConfigurationProperties({RedisProperties.class,BookStaticProperties.class})  //激活读取配置注解的注解
@SpringBootApplication
@MapperScan("com.amuse.frameone.dao")
public class FrameoneApplication {


	public static void main(String[] args) {
		SpringApplication.run(FrameoneApplication.class, args);
	}
}
