package com.shaoyuanhu.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: ShaoYuanHu
 * @Description: http请求的切面实现，@Aspect表示这是一个切面类，@Component将这个切面类交给spring容器管理
 * @Date: Create in 2018/1/22 21:40
 */
@Aspect
@Component
public class HttpAscept {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpAscept.class);

    /**
     * 抽取出来的切点，避免重复书写切面表达式
     * @Pointcut("execution(public * com.shaoyuanhu.controller.*..*(..))")
     * 使用@Pointcut注解定义一个切点，可以被其他方法引用
     */
    @Pointcut("execution(public * com.shaoyuanhu.controller.*..*(..))")
    public void log(){}

    /**
     * @Before("execution(public * com.shaoyuanhu.controller.*..*(..))")
     * 使用@Before注解，并书写切面表达式，表示该方法将在切面表达式限定的所有方法执行前执行。
     */
    @Before("log()")
    public void doBefore(JoinPoint joinpoint){
//        LOGGER.info("this is doBefore method");
//        System.out.println("this is doBefore method");
        //打印请求中的内容
        //获取请求对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        LOGGER.info("url={}", request.getRequestURL());

        //method
        LOGGER.info("method={}", request.getMethod());

        //ip
        LOGGER.info("ip={}", request.getRemoteAddr());

        //类方法
        LOGGER.info("class_method={}", joinpoint.getSignature().getDeclaringTypeName()+"."+joinpoint.getSignature().getName());

        //参数
        LOGGER.info("args={}", joinpoint.getArgs());
    }

    /**
     * @After("execution(public * com.shaoyuanhu.controller.*..*(..))")
     * 使用@After，并书写切面表达式，表示该方法将在切面表达式限定的所有方法执行后执行。
     */
    @After("log()")
    public void doAfter(){
//        LOGGER.info("this is doAfter method");
//        System.out.println("this is doAfter method");
    }

    /**
     * @AfterReturning(value = "log()",returning = "object")
     * 使用@AfterReturning在方法执行完返回时，对返回值进行操作
     * @param object 方法的返回值
     */
    @AfterReturning(value = "log()",returning = "object")
    public void doAfterReturning(Object object){
        //打印方法的返回值
        LOGGER.info("response={}", object.toString());
    }

}
