package com.amuse.frameone.common.aop;

import com.amuse.frameone.common.Enum.SystemEnum;
import com.amuse.frameone.common.exception.BusinessException;
import com.amuse.frameone.common.model.Jwt;
import com.amuse.frameone.common.util.JwtUtil;
import com.amuse.frameone.common.util.ResultUtil;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.server.ExportException;

/**
 * @ClassName MyFilter
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/5/29 11:30
 * @Version 1.0
 */
//采用bean的方式注入
//@Component
//@WebFilter(urlPatterns = "/token/getResource",filterName = "MyFilter")
public class MyFilter implements Filter {

    @Autowired
    private Jwt jwt;

    private final static Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        logger.info("过滤器实现token请求的过滤----");
        if("OPTIONS".equals(request.getMethod())){      //OPTIONS请求不处理
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(request,response);//执行filter
        }else{
            final String authHeader = request.getHeader("authorization");

            if(authHeader == null || !authHeader.startsWith("bearer;")){
                response.sendError(response.SC_UNAUTHORIZED);//返回401错误
                return;
            }
            final String token = authHeader.substring(7);

            //获取容器的jwt BEAN
            if(jwt == null){
                BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
                jwt = (Jwt) factory.getBean("jwt");
            }
            final Claims claims = JwtUtil.parseJWT(token,jwt);

            if(null == claims){
                response.sendError(response.SC_UNAUTHORIZED);//返回401错误
                return;
            }
            filterChain.doFilter(request,response);//执行filter
        }
    }

    @Override
    public void destroy() {

    }
}
