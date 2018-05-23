package com.amuse.frameone.common.exception;

import com.amuse.frameone.common.Enum.SystemEnum;

/**
 * @ClassName BusinessException
 * @Description 自定义回滚异常
 * @Author 刘培振
 * @Date 2018/5/18 9:41
 * @Version 1.0
 */
public class BusinessException extends RuntimeException {

    private String retFlag;
    private String retMsg;

    public BusinessException(){

    }

    public BusinessException(SystemEnum systemEnum){
        this.retFlag = systemEnum.getCode();
        this.retMsg = systemEnum.getMsg();
    }

    public BusinessException(String retFlag, String retMsg) {
        this.retFlag = retFlag;
        this.retMsg = retMsg;
    }

    public String getRetFlag() {
        return retFlag;
    }

    public void setRetFlag(String retFlag) {
        this.retFlag = retFlag;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }
}
