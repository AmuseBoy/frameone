package com.amuse.frameone.service.impl;

import com.amuse.frameone.common.util.RedisUtil;
import com.amuse.frameone.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName RedisServiceImpl
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/5/2 14:48
 * @Version 1.0
 */
@Service
public class RedisServiceImpl implements RedisService {

    private static final Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

    private static Map<String ,Integer> stockMap = null;
    private static Map<String, String> orderMap = new HashMap<>();//订单map

    static {
        //货物map
        stockMap = new HashMap<>();
        stockMap.put("stockOne",100);//共有100件商品
        stockMap.put("stockTwo",50);//共有50件商品
    }

    /**
     * 示例：模拟一个商品订单的redis分布式锁的应用例子
     * @param stockId
     */
    @Override
    @Transactional
    public void orderProductMockDiffUser(String stockId){
        String userId = UUID.randomUUID().toString();//随机模拟用户id;
        this.getRedisLock(stockId,userId);//获取锁
        // 查询库存
        int stockNum = stockMap.get(stockId);
        if(stockNum == 0){
            throw new RuntimeException();
        }else {
            // 下单
            orderMap.put(userId,stockId);
            stockMap.put(stockId,stockNum-1);//库存减一
        }
        this.releaseRedisLock(stockId,userId);//释放锁
    }

    /**
     * 打印上面例子的结果
     */
    public void getOrder(){
        logger.info("剩余商品数量:{}",stockMap.get("stockOne").toString());
        logger.info(orderMap.toString());
        logger.info("订单数量:{}",orderMap.size()+"");
    }



    /**
     * 获取redis分布式锁
     * @param lockKey
     * @param value
     * @return
     */
    private boolean getRedisLock(String lockKey,String value){
        Jedis jedis = RedisUtil.getJedis();
        //已经存在锁，循环等待获取
        while (jedis.exists(lockKey)){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String result = jedis.set(lockKey,value,"NX","PX",5000);
        jedis.close();
        if("OK".equals(result)){
            return true;
        }
        return false;
    }

    /**
     * 释放redis锁
     * @param lockKey
     * @param value
     * @return
     */
    private boolean releaseRedisLock(String lockKey,String value){
        Jedis jedis = RedisUtil.getJedis();
        String script = "if redis.call('get',KEYS[1]) == ARGV[1] \n" +
                "then \n" +
                "    return redis.call('del',KEYS[1]) \n" +
                "else \n" +
                "    return 0 \n" +
                "end";
        Object result = jedis.eval(script,Collections.singletonList(lockKey),Collections.singletonList(value));
        jedis.close();
        if("OK".equals(result)){
            return true;
        }
        return false;
    }


}
