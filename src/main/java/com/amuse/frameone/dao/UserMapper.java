package com.amuse.frameone.dao;

import com.amuse.frameone.common.model.User;

import java.util.List;

/**
 * @author 刘培振
 * @desc
 * @create 2018-04-22 21:10
 **/
public interface UserMapper {

    User getUser(Integer id);

    List<User> getUserList();

    int addUser(User user);

    int saveAndUpdate(User user);
}
