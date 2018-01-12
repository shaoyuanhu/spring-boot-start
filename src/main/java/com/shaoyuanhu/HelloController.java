package com.shaoyuanhu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: ShaoYuanHu
 * @Date: 2018/1/11
 */
//@RestController
@Controller
@RequestMapping("/he")
public class HelloController {

    /*@Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;*/

    @Autowired
    private GirlProperties girlProperties;

    //@RequestMapping(value = {"/hello","/hi"}, method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    //@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    //@GetMapping(value = "/hello",produces = "application/json; charset=utf-8")
    @GetMapping(value = "/hello",produces = "text/html; charset=utf-8")
    @ResponseBody
    //public String hello(@PathVariable("name")String name){
    public String hello(@RequestParam(value = "name",required = true,defaultValue = "xiaohei")String name){
    //public String hello(String name){
//        return "Hello Spring Boot!! " + cupSize + "\t" + age;
//        return girlProperties.getCupSize()+"--"+girlProperties.getAge();
        return name;
    }

}
