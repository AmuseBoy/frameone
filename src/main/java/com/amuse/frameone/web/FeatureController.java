package com.amuse.frameone.web;

import com.amuse.frameone.common.config.BookProperties;
import com.amuse.frameone.common.config.BookStaticProperties;
import com.amuse.frameone.common.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
