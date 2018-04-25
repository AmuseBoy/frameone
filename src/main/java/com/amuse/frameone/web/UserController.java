package com.amuse.frameone.web;

import com.amuse.frameone.common.model.User;
import com.amuse.frameone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘培振
 * @desc 用户
 * @create 2018-04-22 20:29
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    
    /**
     * @Desc 获取用户
     * @Author 刘培振
     * @Date 2018/4/22-20:36
     */
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public User getUser(@RequestParam String id){
        return userService.getUser(id);
    }



}
