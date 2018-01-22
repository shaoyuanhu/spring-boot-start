package com.shaoyuanhu.utils;

import com.shaoyuanhu.domain.Result;

/**
 * @Author: ShaoYuanHu
 * @Description: 封装的返回值工具类
 * @Date: Create in 2018/1/22 22:21
 */
public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
