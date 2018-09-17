package com.amuse.frameone.web;

import com.amuse.frameone.common.Enum.SystemEnum;
import com.amuse.frameone.common.model.Jwt;
import com.amuse.frameone.common.model.User;
import com.amuse.frameone.common.util.JwtUtil;
import com.amuse.frameone.common.util.ResultUtil;
import com.amuse.frameone.service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TokenController
 * @Description     使用jwt进行登陆验证流程
 *                  1.用户使用账号和面发出post请求；
 *                  2.服务器使用私钥创建一个jwt；
 *                  3.服务器返回这个jwt给浏览器；
 *                  4.浏览器将该jwt串在请求头中像服务器发送请求；
 *                  5.服务器验证该jwt；
 *                  6.返回响应的资源给浏览器。
 * @Author 刘培振
 * @Date 2018/5/29 10:41
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/token")
public class TokenController {

    @Autowired
    private UserService userService;

    @Autowired
    private Jwt jwt;

    /**
     * http://localhost:8002/token/login
     * {
     * "id":"0001",
     * "password":"123456"
     * }
     * 登陆接口
     * @param userReq
     * @return
     * @throws JSONException
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,Object> login(@RequestBody User userReq) throws JSONException {
        if(StringUtils.isEmpty(userReq.getId())){
            return new ResultUtil().fail(SystemEnum.PARAM_IS_NULL);
        }
        if(StringUtils.isEmpty(userReq.getPassword())){
            return new ResultUtil().fail(SystemEnum.PARAM_IS_NULL);
        }
        User user = userService.getUser(userReq.getId());
        if(null == user){
            return new ResultUtil().fail(SystemEnum.USER_IS_NULL);
        }
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean is_password = encoder.matches(userReq.getPassword(),user.getPassword());
        if(!is_password){
            return new ResultUtil().fail(SystemEnum.PASSWORD_ISNOT_RIGHT);
        }
        //生成token
        String jwtToken = JwtUtil.createJWT(userReq.getName(),"admin_role",jwt);
        Map<String,Object> map = new HashMap<>();
        map.put("token","bearer;"+jwtToken);
        return new ResultUtil().success(map);
    }

    /**
     * 资源获取，测试token
     * @return
     */
    @RequestMapping(value = "/getResource",method = RequestMethod.GET)
    public String getResource(){
        return "这是资源";
    }

}
