package com.shaoyuanhu.dao;

import com.shaoyuanhu.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: ShaoYuanHu
 * @Description:
 * @Date: Create in 2018/1/21 11:58
 */
public interface GirlRepository extends JpaRepository<Girl, Long> {

    //根据年龄查询
    public List<Girl> findByAge(Integer age);

}
