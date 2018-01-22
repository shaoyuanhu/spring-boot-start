package com.shaoyuanhu.service;

import com.shaoyuanhu.dao.GirlRepository;
import com.shaoyuanhu.domain.Girl;
import com.shaoyuanhu.enums.ResultEnum;
import com.shaoyuanhu.exception.GirlException;
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

    public void getAge(Long id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            //还是一个小学生
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age < 16) {
            //还是一个初中生
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过id查询一个女生信息
     * @param id
     * @return
     */
    public Girl findOne(Long id){
        return girlRepository.findOne(id);
    }

}
