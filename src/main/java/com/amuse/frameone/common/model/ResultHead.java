package com.amuse.frameone.common.model;

import com.amuse.frameone.common.Enum.SystemEnum;

import java.io.Serializable;

/**
 * @ClassName ResultHead
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/5/18 10:37
 * @Version 1.0
 */
public class ResultHead implements Serializable {

    private static final long serialVersionUID = 1L;

    private String retFlag;
    private String retMsg;

    public ResultHead(){

    }

    public ResultHead(SystemEnum systemEnum){
        this.retFlag = systemEnum.getCode();
        this.retMsg = systemEnum.getMsg();
    }

    public ResultHead(String retFlag, String retMsg) {
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
