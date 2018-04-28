package com.amuse.frameone.web;

import com.amuse.frameone.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.logging.logback.*;
/**
 * @author 刘培振
 * @desc    日志测试
 * @create 2018-04-27 22:58
 **/
@RestController
@RequestMapping(value = "/log")
public class LogController {

    private final static Logger logger = LoggerFactory.getLogger(LogController.class);

    @Autowired
    private LogService logService;

    /**
     * @Desc 日志测试
     * @Author 刘培振
     * @Date 2018/4/27-23:14
     */
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public void testLog(){
        logger.debug("这是debug级别日志");
        logger.info("这是INFO级别日志");
        logger.warn("这是WARN级别日志");
        logger.error("这是ERROR级别日志");
    }


}
