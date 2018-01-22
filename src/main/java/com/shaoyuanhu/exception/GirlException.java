package com.shaoyuanhu.exception;

import com.shaoyuanhu.enums.ResultEnum;

/**
 * @Author: ShaoYuanHu
 * @Description: 自定义异常类
 * @Date: Create in 2018/1/22 22:40
 */
public class GirlException extends RuntimeException {

    /** 异常错误的code */
    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
