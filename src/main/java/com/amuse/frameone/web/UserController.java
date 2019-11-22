package com.amuse.frameone.web;

import com.amuse.frameone.common.model.User;
import com.amuse.frameone.common.util.ResultUtil;
import com.amuse.frameone.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 刘培振
 * @desc 用户
 * @create 2018-04-22 20:29
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    
    /**
     * @Desc 获取用户
     * @Author 刘培振
     * @Date 2018/4/22-20:36
     */
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    //@Transactional
    public Map<String, Object> getUser(@RequestParam Integer id){
//        for(int i=0;i<100;i++){
//            logger.info("开始:{}",System.currentTimeMillis());
//            User user = userService.getUser(id);
//            logger.info("结束:{}",System.currentTimeMillis());
//        }
//        User user = userService.getUser(id);
//        System.out.println("user:"+user.getName());
//        try {
//            Thread.sleep(1000*30);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        User user1 = userService.getUser(id);
        System.out.println("user1:"+user1.getName());
        user1.setAge(100);
        userService.saveAndUpdate(user1);
        System.out.println("我有没有输出");
        return new ResultUtil().success(user1);
    }

    /**
     * 全部查询
     * @return
     */
    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    public Map<String,Object> getUserList(){
        List<User> list = userService.getUserList();
        return new ResultUtil().success(list);
    }

    /**
     * 新建用户
     * {
     * "name":"Jack",
     * "age":12,
     * "sex":1,
     * "birth":"1991-03-13",
     * "email":"123@163.com",
     * "password":""
     * }
     * @param user
     */
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Map<String,Object> addUser(@RequestBody User user){
        long startTime = System.currentTimeMillis();
        int j = userService.addUser(user);
        long endTime = System.currentTimeMillis();
        System.out.println("---耗时:---"+(endTime-startTime));
        return new ResultUtil().success();
    }

    /**
     * 保存或更新
     * @param user
     * @return
     */
    @RequestMapping(value = "/saveAndUpdate",method = RequestMethod.POST)
    public Map<String,Object> saveAndUpdate(@RequestBody User user){
        int j = userService.saveAndUpdate(user);
        logger.info("影响行数:"+j);
        return new ResultUtil().success();
    }



}
