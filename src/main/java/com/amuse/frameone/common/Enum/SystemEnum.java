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

    SERVICE_ERROR("99991","业务异常"),

    PARAM_IS_NULL("P0001","参数不能为空"),

    USER_IS_NULL("S0001","用户不存在"),

    PASSWORD_ISNOT_RIGHT("S0002","密码不正确"),

    LOGIN_STATUS_ERROR("S0003","登陆状态异常");


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
