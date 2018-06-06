package com.amuse.frameone.common.config;

import com.amuse.frameone.common.aop.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName WebMvcConfigurer
 * @Description 拦截器注入到springMVC中
 * @Author 刘培振
 * @Date 2018/5/29 14:04
 * @Version 1.0
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**");
    }
}
