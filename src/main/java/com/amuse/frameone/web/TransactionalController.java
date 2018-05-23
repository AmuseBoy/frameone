package com.amuse.frameone.web;


import com.amuse.frameone.common.model.User;
import com.amuse.frameone.common.util.ResultUtil;
import com.amuse.frameone.service.TransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName TransactionalController
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/5/22 11:53
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/transactional")
public class TransactionalController {

    @Autowired
    private TransactionalService transactionalService;

    /**
     * 事物测试
     * @param user
     * @return
     */
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Map<String,Object> addUser(@RequestBody User user){
        transactionalService.addUser(user);
        return new ResultUtil().success();
    }


}


