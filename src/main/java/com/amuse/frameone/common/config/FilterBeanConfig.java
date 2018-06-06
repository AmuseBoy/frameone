package com.amuse.frameone.common.config;

import com.amuse.frameone.common.aop.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FilterBeanConfig
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/5/29 11:43
 * @Version 1.0
 */
@Configuration
public class FilterBeanConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        List<String> urlPatterns = new ArrayList<>();
        MyFilter myFilter = new MyFilter();
        //urlPatterns.add("/*");                  // /** 不行
        urlPatterns.add("/token/getResource");
        filterRegistrationBean.setFilter(myFilter);
        filterRegistrationBean.setUrlPatterns(urlPatterns);
        return filterRegistrationBean;
    }
}
