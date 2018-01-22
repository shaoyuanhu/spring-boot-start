package com.shaoyuanhu.domain;

/**
 * @Author: ShaoYuanHu
 * @Description: 接口返回的统一值对象
 * @Date: Create in 2018/1/22 22:15
 */
public class Result<T> {

    /** 返回值编码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 返回的数据. */
     private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
