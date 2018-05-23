package com.amuse.frameone.common.Enum;

/**
 * @ClassName SystemEnum
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/5/22 14:16
 * @Version 1.0
 */
public enum SystemEnum {

    SYSTEM_SUCCESS("00000","处理成功"),

    SYSTEM_FAIL("99999","通讯异常"),

    SERVICE_ERROR("99991","业务异常");



    private String code;
    private String msg;

    private SystemEnum(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
