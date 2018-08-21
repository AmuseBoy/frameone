package com.amuse.frameone.web;

import com.amuse.frameone.service.HttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HttpController
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/7/27 19:39
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/http")
public class HttpController {

    @Autowired
    private HttpService httpService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public void testHttp(){
        httpService.httpClient();
    }

}
