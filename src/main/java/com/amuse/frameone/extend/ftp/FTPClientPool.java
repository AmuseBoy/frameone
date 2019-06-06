package com.amuse.frameone.extend.ftp;

import com.amuse.frameone.common.config.FtpPoolConfig;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName FTPClientPool
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/9/26 13:37
 * @Version 1.0
 */
@Component
public class FTPClientPool {

    private final static Logger logger = LoggerFactory.getLogger(FTPClientPool.class);

    @Autowired
    private FtpPoolConfig ftpPoolConfig;

    //可以支持多个连接池,本例只存放一个连接池
    private static ConcurrentHashMap<String ,GenericObjectPool<FTPClient>> pools = new ConcurrentHashMap<>();

    //private GenericObjectPool<FTPClient> pool;

    /**
     * 获取ftp池
     * @return
     */
    private GenericObjectPool<FTPClient> getPool(){
        GenericObjectPool<FTPClient> pool = pools.get(ftpPoolConfig.getHost());
        if(null == pool){
            FTPClientFactory ftpClientFactory = new FTPClientFactory(ftpPoolConfig);
            pool = new GenericObjectPool<>(ftpClientFactory ,ftpPoolConfig);
            pool.setMaxTotal(ftpPoolConfig.getMaxTotal());
            pool.setMaxIdle(ftpPoolConfig.getMaxIdle());
            pool.setMinIdle(ftpPoolConfig.getMinIdle());
            pool.setTestOnBorrow(true);
        }
        pools.put(ftpPoolConfig.getHost(),pool);
        return pool;
    }

    /**
     * 获取一个连接对象
     * @return
     * @throws Exception
     */
    public FTPClient borrowObject() {
        try {
            FTPClient client = getPool().borrowObject();
            return client;
        } catch (Exception e) {
            logger.error("获取FTPClient失败:{}",e);
            return null;
        }
    }

    /**
     * 返回一个连接对象
     * @param ftpClient
     */
    public void returnObject(FTPClient ftpClient){
        if(ftpClient != null ){
            getPool().returnObject(ftpClient);
        }
    }
}
