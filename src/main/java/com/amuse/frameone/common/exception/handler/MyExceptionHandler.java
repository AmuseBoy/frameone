package com.amuse.frameone.common.exception.handler;

import com.amuse.frameone.common.exception.BusinessException;
import com.amuse.frameone.common.model.ResultHead;
import com.amuse.frameone.common.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @ClassName ExceptionHandler
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/5/22 14:50
 * @Version 1.0
 */
@ControllerAdvice
public class MyExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String,Object> handlerRuntimeException(RuntimeException e){
        logger.error("捕捉RuntimeException:{}",e);
        return new ResultUtil().fail();
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Map<String,Object> handlerBusinessException(BusinessException e){
        logger.error("捕捉BusinessException:{}",e);
        return new ResultUtil().fail(e.getRetFlag(),e.getRetMsg());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> handlerException(Exception e){
        logger.error("捕捉Exception:{}",e);
        return new ResultUtil().fail();
    }

}
