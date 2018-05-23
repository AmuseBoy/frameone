package com.amuse.frameone.web;

import com.amuse.frameone.common.model.Book;
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


    /**
     * produces作用，服务端可以制定返回的数据类型 application/xml 或者 application/json
     * @param id
     * @return
     */
    @RequestMapping(value = "/getBook/{id}", method = RequestMethod.GET,produces = {"application/xml"})
    public Book getBook(@PathVariable("id") String id){
        return new Book(id,"java编程思想");
    }

}
