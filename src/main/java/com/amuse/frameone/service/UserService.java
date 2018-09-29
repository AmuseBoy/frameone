package com.amuse.frameone.service;

import com.amuse.frameone.common.model.User;

import java.util.List;

/**
 * @author 刘培振
 * @desc
 * @create 2018-04-22 21:06
 **/
public interface UserService {

    User getUser(Integer id);

    List<User> getUserList();

    int addUser(User user);
}
