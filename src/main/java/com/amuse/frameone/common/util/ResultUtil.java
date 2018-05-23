package com.amuse.frameone.common.util;

import com.amuse.frameone.common.Enum.SystemEnum;
import com.amuse.frameone.common.model.ResultHead;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ResultUtil
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/5/18 10:55
 * @Version 1.0
 */
public class ResultUtil {

    public static Map<String,Object> success(){
        Map<String,Object> map = new HashMap<>();
        map.put("head", new ResultHead(SystemEnum.SYSTEM_SUCCESS));
        return map;
    }

    public static Map<String,Object> success(Object result){
        Map<String,Object> map = new HashMap<>();
        map.put("head", new ResultHead(SystemEnum.SYSTEM_SUCCESS));
        map.put("body", result);
        return map;
    }

    public static Map<String,Object> fail(){
        Map<String,Object> map = new HashMap<>();
        map.put("head", new ResultHead(SystemEnum.SYSTEM_FAIL));
        return map;
    }

    public static Map<String,Object> fail(String retFlag,String retMsg){
        Map<String,Object> map = new HashMap<>();
        map.put("head", new ResultHead(retFlag,retMsg));
        return map;
    }
}
