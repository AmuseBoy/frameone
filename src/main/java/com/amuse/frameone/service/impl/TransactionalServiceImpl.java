package com.amuse.frameone.service.impl;

import com.amuse.frameone.common.Enum.SystemEnum;
import com.amuse.frameone.common.exception.BusinessException;
import com.amuse.frameone.common.model.User;
import com.amuse.frameone.dao.UserMapper;
import com.amuse.frameone.service.TransactionalService;
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

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public void addUser(User user){
        userMapper.addUser(user);
        //throw new NullPointerException();
        //throw new BusinessException(SystemEnum.SERVICE_ERROR);
    }

}
