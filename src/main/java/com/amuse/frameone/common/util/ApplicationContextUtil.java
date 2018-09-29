package com.amuse.frameone.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName ApplicationContextUtil
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/9/29 11:00
 * @Version 1.0
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext ac = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ac = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return ac;
    }

    /**
     * 通过name获取Bean
     * @param name
     * @return
     */
    public static Object getBean(String name) {
        return ac.getBean(name);
    }

    /**
     * 通过class获取Bean
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        return ac.getBean(clazz);
    }

    /**
     * 通过name clazz获取Bean
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return ac.getBean(name, clazz);
    }

}
