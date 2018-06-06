package com.amuse.frameone.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName HttpAspect
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/5/22 10:30
 * @Version 1.0
 */

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    long startTime;
    long endTime;

    /**
     * 路径：包下面的任意类.方法.参数
     */
    @Pointcut("execution(public * com.amuse.frameone.web.*.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){

        startTime = System.currentTimeMillis();

        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("AOP--url={}",request.getRequestURI());
        logger.info("AOP--method={}",request.getMethod());
        logger.info("AOP--ip={}",request.getRemoteAddr());
        logger.info("AOP--class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("AOP--args={}",joinPoint.getArgs().toString());
    }

    @After("log()")
    public void doAfter(){
        endTime = System.currentTimeMillis();
        logger.info("AOP--costTime={}ms",endTime-startTime);
    }

    @AfterReturning(returning = "obj", pointcut = "log()")
    public void doAfterReturning(Object obj){
        logger.info("AOP--response={}",obj);
    }
}
