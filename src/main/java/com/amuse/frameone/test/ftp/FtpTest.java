package com.amuse.frameone.test.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ClassName FtpTest
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/8/21 17:09
 * @Version 1.0
 */
public class FtpTest {

    private final static Logger logger = LoggerFactory.getLogger(FtpTest.class);

    public static void main(String[] args) {
        FTPClient ftpClient = new FTPClient();
        try {
            InetAddress address = InetAddress.getByName("192.168.32.128");
            ftpClient.connect(address,21);
            ftpClient.setControlEncoding("UTF-8");
            ftpClient.enterLocalPassiveMode();
            int replyCode = ftpClient.getReplyCode();
            if(!FTPReply.isPositiveCompletion(replyCode)){
                logger.info("连接FTP失败:"+replyCode);
            }
            boolean result = ftpClient.login("admin","admin");
            if(!result){
                logger.info("登陆FTP失败:"+result);
            }
            ftpClient.changeWorkingDirectory("/");
            String[] names = ftpClient.listNames();
            for (String s : names){
                logger.info("fielName:"+s);
            }

        } catch (Exception e) {
            logger.error("{}",e);
        }finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                logger.error("{}",e);
            }
        }
    }
}
