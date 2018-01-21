package com.shaoyuanhu.controller;

import com.shaoyuanhu.pojo.Girl;
import com.shaoyuanhu.dao.GirlRepository;
import com.shaoyuanhu.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: ShaoYuanHu
 * @Description:
 * @Date: Create in 2018/1/21 11:55
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有的女生
     * @return
     */
    @RequestMapping(value = "/getGirls")
    public List<Girl> getGirls(){
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生对象数据
     * @param cupSize
     * @param age
     * @return
     */
    @RequestMapping(value = "/addGirl")
    public Girl addGirl(String cupSize, Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        Girl save = girlRepository.save(girl);
        return save;
    }

    /**
     * 查询一个女生
     * @param id
     * @return
     */
    @RequestMapping("/getGirl")
    public Girl getGirl(Long id){
        return girlRepository.findOne(id);
    }

    /**
     * 更新一个女生的信息
     * @return
     */
    @RequestMapping("/updateGirl")
    public Girl updateGirl(Long id,String cupSize,Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        Girl save = girlRepository.save(girl);
        return save;
    }

    /**
     * 根据主键删除一个女生的信息
     * @param id
     */
    @RequestMapping("/deleteGirl")
    public void deleteGirl(Long id){
        girlRepository.delete(id);
    }

    /**
     * 根据年龄查询女生列表
     * @param age
     * @return
     */
    @RequestMapping("/getGirlsByAge")
    public List<Girl> getGirlsByAge(Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * 分页查询女生信息
     * @return
     */
    @RequestMapping("/getGirlsByPage")
    public Page<Girl> getGirlsByPage(Integer pageSize,Integer pageNum){
        Pageable pageable = new Pageable() {
            @Override
            public int getPageNumber() {
                return pageNum;
            }

            @Override
            public int getPageSize() {
                return pageSize;
            }

            @Override
            public int getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        };
        Page<Girl> all = girlRepository.findAll(pageable);
        return all;
    }

    @RequestMapping("/addTwoGirl")
    public void addTwoGirl(){
        girlService.addTwoGirl();
    }

}
