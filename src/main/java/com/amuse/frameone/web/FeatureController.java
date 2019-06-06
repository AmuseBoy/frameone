package com.amuse.frameone.web;

import com.alibaba.fastjson.JSONObject;
import com.amuse.frameone.common.model.BookProperties;
import com.amuse.frameone.common.model.BookStaticProperties;
import com.amuse.frameone.common.model.Book;
import com.amuse.frameone.common.util.ApplicationContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FeatureController
 * @Description springMVC的一些实用特性
 * @Author 刘培振
 * @Date 2018/5/22 17:07
 * @Version 1.0
 */
@RestController
@RequestMapping("/feature")
public class FeatureController {


    @Autowired
    private Book book;

    @Autowired
    private BookProperties bookProperties;

    /**
     * produces作用，服务端可以制定返回的数据类型 application/xml 或者 application/json
     * http://localhost:8002/feature/getBook/001
     * @param id
     * @return
     */
    @RequestMapping(value = "/getBook/{id}", method = RequestMethod.GET,produces = {"application/xml"})
    public Book getBook(@PathVariable("id") String id){
        return book;
    }


    /**
     * 动态获取配置文件
     * http://localhost:8002/feature/getBookProperties/001
     * @param id
     * @return
     */
    @RequestMapping(value = "/getBookProperties/{id}", method = RequestMethod.GET)
    public BookProperties getBookProperties(@PathVariable("id") String id){
        return bookProperties;
    }

    /**
     * 静态获取配置文件
     * http://localhost:8002/feature/getBookStaticProperties/001
     * @param id
     * @return
     */
    @RequestMapping(value = "/getBookStaticProperties/{id}", method = RequestMethod.GET)
    public String getBookStaticProperties(@PathVariable("id") String id){
        System.out.println(BookStaticProperties.getName()+"------------");
        return BookStaticProperties.getName();
    }

    /**
     * HttpServletRequest使用方式
     * http://localhost:8002/feature/response?id=qqq
     * @param request
     * @param response
     */
    @RequestMapping(value = "/response", method = RequestMethod.GET)
    public void response(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String id = (String) request.getAttribute("id");
        //...逻辑处理
        Map<String,Object> map = new HashMap<>();
        map.put("res","成功");
        response.setContentType("application/json; charset=utf-8");
        response.getOutputStream().write(map.toString().getBytes("UTF-8"));
    }

    /**
     * 使用ApplicationContextAware获取bean
     * 使用WebApplicationContextUtils获取bean
     * @return
     */
    @RequestMapping(value = "/getBookByBeanUtil", method = RequestMethod.GET)
    public Book getBookByBeanUtil(HttpServletRequest request){
        //使用ApplicationContextAware获取bean
        /*ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
        Book book = (Book) ac.getBean("book");
        return book;*/

        //使用WebApplicationContextUtils获取bean
        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        Book book = (Book) ac.getBean("book");
        return book;
    }

    /**
     *http://localhost:8002/feature/psotForMap
     * @param map
     */
    @RequestMapping(value = "/psotForMap" , method = RequestMethod.POST)
    public void postForMap(@RequestBody Map map){
        System.out.println(map.get("id"));
        System.out.println(map.get("name"));
    }

    /**
     *http://localhost:8002/feature/postForJson
     * @param jsonObject
     */
    @RequestMapping(value = "/postForJson" , method = RequestMethod.POST)
    public void postForJson(@RequestBody JSONObject jsonObject){
        System.out.println(jsonObject.getString("id"));
        System.out.println(jsonObject.getString("name"));
    }
}
