package com.amuse.frameone.service.impl;

import com.amuse.frameone.service.ThreadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName ThreadServiceImpl
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/7/14 13:53
 * @Version 1.0
 */
@Service
public class ThreadServiceImpl implements ThreadService {

    private final static Logger logger = LoggerFactory.getLogger(ThreadServiceImpl.class);

    public String executeWork(int i,String name){
        logger.info("线程:"+name+"--"+i);
        return name;
    }
}
