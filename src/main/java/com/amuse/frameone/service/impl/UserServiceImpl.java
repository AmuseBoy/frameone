package com.amuse.frameone.service.impl;

import com.amuse.frameone.common.model.User;
import com.amuse.frameone.dao.UserMapper;
import com.amuse.frameone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 刘培振
 * @desc
 * @create 2018-04-22 21:06
 **/
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(Integer id) {
        return userMapper.getUser(id);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public int addUser(User user){
        return userMapper.addUser(user);
    }

    @Override
    public int saveAndUpdate(User user){
        return userMapper.saveAndUpdate(user);
    }
}
