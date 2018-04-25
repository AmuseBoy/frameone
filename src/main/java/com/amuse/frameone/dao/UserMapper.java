package com.amuse.frameone.dao;

import com.amuse.frameone.common.model.User;

/**
 * @author 刘培振
 * @desc
 * @create 2018-04-22 21:10
 **/
public interface UserMapper {

    User getUser(String id);
}
