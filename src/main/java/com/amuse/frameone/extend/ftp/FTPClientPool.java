package com.amuse.frameone.extend.ftp;

import com.amuse.frameone.common.config.FtpPoolConfig;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName FTPClientPool
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/9/26 13:37
 * @Version 1.0
 */
@Component
public class FTPClientPool {

    @Autowired
    private FtpPoolConfig ftpPoolConfig;

    private GenericObjectPool<FTPClient> pool;

    /**
     * 获取ftp池
     * @return
     */
    private GenericObjectPool<FTPClient> getPool(){
        if(null == pool){
            FTPClientFactory ftpClientFactory = new FTPClientFactory(ftpPoolConfig);
            pool = new GenericObjectPool<>(ftpClientFactory ,ftpPoolConfig);
        }
        return pool;
    }

    /**
     * 获取一个连接对象
     * @return
     * @throws Exception
     */
    public FTPClient borrowObject() throws Exception{
        FTPClient client = getPool().borrowObject();
        return client;
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
