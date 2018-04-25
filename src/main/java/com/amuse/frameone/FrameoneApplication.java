package com.amuse.frameone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.amuse.frameone.dao")
public class FrameoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrameoneApplication.class, args);
	}
}
