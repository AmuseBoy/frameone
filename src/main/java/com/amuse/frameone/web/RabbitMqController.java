package com.amuse.frameone.web;

import com.amuse.frameone.service.RabbitMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RabbitMqController
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/7/15 16:05
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/rabbit")
public class RabbitMqController {

    @Autowired
    private RabbitMqService rabbitMqService;

    @RequestMapping(value = "/test")
    public void testRabbitMq(){
        rabbitMqService.send();
    }
}
