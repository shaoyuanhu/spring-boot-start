package com.shaoyuanhu.controller;

import com.shaoyuanhu.SpringBootStartApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * @Author: ShaoYuanHu
 * @Description: controller测试类
 * @Date: Create in 2018/1/22 23:03
 */
@AutoConfigureMockMvc
public class GirlControllerTest extends SpringBootStartApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getGirls() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getGirls"))
                .andExpect(MockMvcResultMatchers.status().isOk());
//                .andExpect(MockMvcResultMatchers.content().string("abc"));
    }
}