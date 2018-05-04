package com.amuse.frameone.web;

import com.amuse.frameone.common.util.RedisProperties;
import com.amuse.frameone.common.util.RedisUtil;
import com.amuse.frameone.service.RedisService;
import com.amuse.frameone.service.impl.RedisServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RedisController
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/4/29 11:54
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/redis")
public class RedisController {

    private final static Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisService redisService;

    /**
     * 简单测试springboot集成的redis使用
     */
    @RequestMapping(value = "/testRedis",method = RequestMethod.GET)
    public void testRedis(){
        stringRedisTemplate.opsForValue().set("myKey","myValue");
        boolean hasKey = stringRedisTemplate.hasKey("myKey");
        logger.info("是否有值:{}",hasKey);
        RedisUtil.set("mykey2","myvalue2");
        logger.info(RedisUtil.get("mykey2"));
    }


    /**
     * 示例：模拟一个商品订单的redis分布式锁的应用例子
     * @param stockId
     */
    @RequestMapping(value = "/RedisBuy",method = RequestMethod.GET)
    public void RedisBuy(@RequestParam String stockId){
        redisService.orderProductMockDiffUser(stockId);
    }

    /**
     * 示例：模拟一个商品订单的redis分布式锁的应用例子
     * 获取结果信息
     */
    @RequestMapping(value = "/getOrder",method = RequestMethod.GET)
    public void getOrder(){
        redisService.getOrder();
    }

}
