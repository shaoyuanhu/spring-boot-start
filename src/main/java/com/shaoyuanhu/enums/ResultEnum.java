package com.shaoyuanhu.enums;

/**
 * @Author: ShaoYuanHu
 * @Description: 返回值枚举，统一管理返回值信息
 * @Date: Create in 2018/1/22 22:49
 */
public enum ResultEnum {
    UNKONW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"还是一个小学生"),
    MIDDLE_SCHOOL(101,"还是一个初中生")
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
