package com.shaoyuanhu.service;

import com.shaoyuanhu.dao.GirlRepository;
import com.shaoyuanhu.pojo.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Author: ShaoYuanHu
 * @Description:
 * @Date: Create in 2018/1/21 12:39
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void addTwoGirl(){
        Girl girlA = new Girl();
        girlA.setAge(25);
        girlA.setCupSize("B");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(22);
        girlB.setCupSize("A");
//        int x = 1/0;
        girlRepository.save(girlB);
    }

}
