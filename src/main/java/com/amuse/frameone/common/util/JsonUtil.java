package com.amuse.frameone.common.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.amuse.frameone.common.model.Book;

import java.util.Map;

/**
 * @ClassName JsonUtil
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/6/30 12:15
 * @Version 1.0
 */
public class JsonUtil {

    public static void main(String[] args) {

        String str = "{\"id\":\"0001\",\"name\":\"Java编程思想\"}";

        JSONObject jsonObject = JSON.parseObject(str);
        System.out.println("string->json:"+jsonObject);

        String str1 = jsonObject.toJSONString();
        System.out.println("json->string:"+str1);

        Map<String,Object> map = jsonObject;
        System.out.println("json->map:"+map.toString());

        jsonObject = new JSONObject(map);
        System.out.println("map->json:"+jsonObject);

        //Book book = JSON.parseObject(str,new TypeReference<Book>(){});
        Book book = JSON.parseObject(str,Book.class);
        System.out.println("string->javaBean:"+book.toString());

        str = JSON.toJSONString(book);
        System.out.println("javaBean->string:"+str);
    }









}
