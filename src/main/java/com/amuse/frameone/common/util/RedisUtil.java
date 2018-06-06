package com.amuse.frameone.common.util;

import com.amuse.frameone.common.model.RedisProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @ClassName RedisUtil
 * @Description spring集成的redis工具不够灵活，这里自己定义
 * @Author 刘培振
 * @Date 2018/4/29 13:21
 * @Version 1.0
 */
public class RedisUtil {

    private final static Logger logger = LoggerFactory.getLogger(RedisUtil.class);

    private static JedisPool pool;

    public static JedisPool getPool(){
        if(pool == null){
            String host = RedisProperties.getHost();
            int port = RedisProperties.getPort();
            logger.info(host + "--"+port);
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxIdle(10);//控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
            config.setMaxTotal(20);//如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)
            config.setMaxWaitMillis(20);//表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException
            config.setTestOnBorrow(true);//在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
            pool = new JedisPool(config,host,port,20);
        }
        return pool;
    }

    /**
     * 获取jedis实例
     * @return
     */
    public synchronized static Jedis getJedis(){
        Jedis jedis = null;
        try {
            logger.info("开始获取redis实例,active:{}, idle:{}, waiters:{}",getNumActive(), getNumIdle(), getNumWaiters());
            jedis = getPool().getResource();
        } catch (Exception e) {
            logger.error("获取redis实例失败,active:{}, idle:{}, waiters:{}",getNumActive(), getNumIdle(), getNumWaiters());
            logger.error("异常e:{}",e);
        }
        return jedis;
    }

    public synchronized static void returnResource(Jedis jedis){
        if(jedis != null){
            jedis.close();
        }
    }

    public static int getNumActive() {
        if (pool != null && !pool.isClosed()) {
            return pool.getNumActive();
        }
        return -1;
    }

    public static int getNumIdle() {
        if (pool != null && !pool.isClosed()) {
            return pool.getNumIdle();
        }
        return -1;
    }

    public static int getNumWaiters() {
        if (pool != null && !pool.isClosed()) {
            return pool.getNumWaiters();
        }
        return -1;
    }

    /**
     * set操作
     * @param key
     * @param value
     * @return
     */
    public static String set(String key,String value){
        Jedis jedis = null;
        try {
            jedis = getJedis();
            return jedis.set(key,value);
        } catch (Exception e) {
            logger.error("set({},{})操作失败",key,value);
            logger.error("异常e:{}",e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    /**
     * get操作
     * @param key
     * @return
     */
    public static String get(String key){
        Jedis jedis = null;
        try {
            jedis = getJedis();
            return jedis.get(key);
        } catch (Exception e) {
            logger.error("get({})操作失败",key);
            logger.error("异常e:{}",e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

}
