package com.shaoyuanhu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
    //@Min(value = 18,message = "未成年少女") 表示age不能小于18，如果age小于18，提示信息 未成年少女
    @Min(value = 18,message = "未成年少女")
    private Integer age;
    //@NotNull(message = "money不能为空") 表示money字段不能为空，如果为空，提示信息 money不能为空
    @NotNull(message = "money不能为空")
    private Double money;

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

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

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }
}
