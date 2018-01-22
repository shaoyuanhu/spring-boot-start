package com.shaoyuanhu.service;

import com.shaoyuanhu.SpringBootStartApplicationTests;
import com.shaoyuanhu.domain.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Author: ShaoYuanHu
 * @Description: service测试类
 * @Date: Create in 2018/1/22 22:57
 */
public class GirlServiceTest extends SpringBootStartApplicationTests {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOne() {
        Girl girl = girlService.findOne(1L);
        Assert.assertEquals(new Integer(15),girl.getAge());
    }
}