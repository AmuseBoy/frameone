package com.amuse.frameone.service.impl;

import com.amuse.frameone.common.Enum.SystemEnum;
import com.amuse.frameone.common.exception.BusinessException;
import com.amuse.frameone.common.model.User;
import com.amuse.frameone.dao.UserMapper;
import com.amuse.frameone.service.TransactionalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName TransactionalServiceImpl
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/5/22 14:03
 * @Version 1.0
 */
@Service
public class TransactionalServiceImpl implements TransactionalService {

    private final static Logger logger = LoggerFactory.getLogger(TransactionalServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public void addUser(User user){

        try {
            userMapper.addUser(user);
            this.sss();

            //throw new BusinessException(SystemEnum.SERVICE_ERROR);
        } catch (NullPointerException e) {
            logger.info("service捕捉异常{}:",e);
            throw e;
        }
    }


    public void sss(){
        int a =0;
        throw new NullPointerException();
    }
}
