package com.shaoyuanhu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ShaoYuanHu
 * @Date: 2018/1/11
 */
@RestController
public class HelloController {

    /*@Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;*/

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/hello", produces = "application/json; charset=utf-8")
    public String hello(){
//        return "Hello Spring Boot!! " + cupSize + "\t" + age;
        return girlProperties.getCupSize()+"--"+girlProperties.getAge();
    }

}
