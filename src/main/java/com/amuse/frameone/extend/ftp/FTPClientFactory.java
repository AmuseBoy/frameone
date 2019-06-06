package com.amuse.frameone.extend.ftp;

import com.amuse.frameone.common.config.FtpPoolConfig;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @ClassName FTPClientFactory
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/9/26 10:26
 * @Version 1.0
 */
public class FTPClientFactory extends BasePooledObjectFactory<FTPClient> {

    private final static Logger logger = LoggerFactory.getLogger(FTPClientFactory.class);

    private FtpPoolConfig ftpPoolConfig;

    public FTPClientFactory() {
    }

    public FTPClientFactory(FtpPoolConfig ftpPoolConfig) {
        this.ftpPoolConfig = ftpPoolConfig;
    }

    /**
     * 创建对象
     * @return
     * @throws Exception
     */
    @Override
    public FTPClient create() {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.setConnectTimeout(ftpPoolConfig.getConnectTimeOut());
            ftpClient.connect(ftpPoolConfig.getHost(), ftpPoolConfig.getPort());
            int replyCode = ftpClient.getReplyCode();
            if(!FTPReply.isPositiveCompletion(replyCode)){
                ftpClient.disconnect();
                logger.error("连接FTP失败:"+replyCode);
                return null;
            }
            boolean result = ftpClient.login(ftpPoolConfig.getUsername(),ftpPoolConfig.getPassword());
            if(!result){
                logger.error("登陆FTP失败:"+result);
            }
            ftpClient.setControlEncoding(ftpPoolConfig.getControlEncoding());
            ftpClient.setBufferSize(ftpPoolConfig.getBufferSize());
            ftpClient.setFileType(ftpPoolConfig.getFileType());
            ftpClient.setDataTimeout(ftpPoolConfig.getDataTimeout());
            ftpClient.setUseEPSVwithIPv4(ftpPoolConfig.isUseEPSVwithIPv4());
            if(ftpPoolConfig.isPassiveMode()){
                logger.info("进入ftp被动模式");
                ftpClient.enterLocalPassiveMode();//进入被动模式
            }
        } catch (IOException e) {
            logger.error("FTP连接失败:{}", e);
        }
        return ftpClient;
    }

    @Override
    public PooledObject<FTPClient> wrap(FTPClient ftpClient) {
        return new DefaultPooledObject<FTPClient>(ftpClient);
    }

    /**
     * 销毁对象
     * @param p
     * @throws Exception
     */
    @Override
    public void destroyObject(PooledObject<FTPClient> p) throws Exception {
        FTPClient ftpClient = p.getObject();
        ftpClient.logout();
        ftpClient.disconnect();
    }

    @Override
    public boolean validateObject(PooledObject<FTPClient> p) {
        FTPClient ftpClient = p.getObject();
        boolean connect = false;
        try {
            connect = ftpClient.sendNoOp();
        } catch (IOException e) {
            logger.error("验证ftp连接对象,返回false,{}",e);
        }
        return connect;
    }

    @Override
    public PooledObject<FTPClient> makeObject() throws Exception {
        return super.makeObject();
    }

    @Override
    public void activateObject(PooledObject<FTPClient> p) throws Exception {
        super.activateObject(p);
    }

    @Override
    public void passivateObject(PooledObject<FTPClient> p) throws Exception {
        super.passivateObject(p);
    }
}
