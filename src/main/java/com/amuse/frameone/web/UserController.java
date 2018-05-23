package com.amuse.frameone.web;

import com.amuse.frameone.common.model.User;
import com.amuse.frameone.common.util.ResultUtil;
import com.amuse.frameone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public Map<String, Object> getUser(@RequestParam String id){
        User user = userService.getUser(id);
        return new ResultUtil().success(user);
    }


    /**
     * 新建用户
     * @param user
     */
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Map<String,Object> addUser(@RequestBody User user){
        userService.addUser(user);
        return new ResultUtil().success();
    }
}
