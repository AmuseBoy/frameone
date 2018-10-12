package com.amuse.frameone.web;

import com.amuse.frameone.extend.ftp.FTPClientFactory;
import com.amuse.frameone.extend.ftp.FTPClientPool;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName FtpController
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/9/26 15:38
 * @Version 1.0
 */
@RestController
@RequestMapping("/ftp")
public class FtpController {

    private final static Logger logger = LoggerFactory.getLogger(FtpController.class);

    @Autowired
    private FTPClientPool ftpClientPool;

    /**
     * 测试FTP连接池
     */
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @Transactional
    public void ftpTest(){
        try {
            FTPClient ftpClient = ftpClientPool.borrowObject();
            ftpClient.changeWorkingDirectory("/");
            String[] names = ftpClient.listNames();
            for (String s : names){
                logger.info("fielName:"+s);
                if(s.equals("new.txt")){
                    logger.info("删除文件");
                    ftpClient.deleteFile(s);
                }
            }
            //throw new NullPointerException();
            ftpClientPool.returnObject(ftpClient);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
