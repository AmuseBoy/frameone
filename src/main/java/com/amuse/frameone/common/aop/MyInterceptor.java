package com.amuse.frameone.common.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName MyInterceptor
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/5/29 11:51
 * @Version 1.0
 */
public class MyInterceptor implements HandlerInterceptor {

    private final static Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    //Controller方法调用之前
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info("preHandler被调用");
        return true;//如果为false,停止流程，api被拦截
    }

    //Controller请求处理之后调用，但是再视图被渲染之前
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("postHandler被调用");
    }

    //整个请求结束之后被调用，也就是DispatcherServlet渲染了对应的视图之后执行
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("afterCompletion被调用");
        logger.info("qq{}",e);
    }
}
