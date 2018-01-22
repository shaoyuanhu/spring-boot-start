package com.shaoyuanhu.handle;

import com.shaoyuanhu.domain.Result;
import com.shaoyuanhu.enums.ResultEnum;
import com.shaoyuanhu.exception.GirlException;
import com.shaoyuanhu.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: ShaoYuanHu
 * @Description: 自定义异常处理
 * @Date: Create in 2018/1/22 22:34
 */
@ControllerAdvice
public class ExceptionHandle {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * @ExceptionHandler(value = Exception.class)
     * 使用@ExceptionHandler的value属性，制定捕获的异常的范围
     * @param e 捕获到的异常对象
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof GirlException){
            //判断如果是自定义异常，返回特定信息
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else {
            LOGGER.error("[系统异常]", e);
            //如果不是自定义异常，返回默认信息
            return ResultUtil.error(ResultEnum.UNKONW_ERROR.getCode(),ResultEnum.UNKONW_ERROR.getMsg());
        }
    }

}
