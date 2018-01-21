package com.shaoyuanhu.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author: ShaoYuanHu
 * @Description: 使用@Entity注解表示该类对应数据库中的表
 * @Date: Create in 2018/1/21 11:42
 */
@Entity
public class Girl {

    @Id
    @GeneratedValue
    private Long id;
    private String cupSize;
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
