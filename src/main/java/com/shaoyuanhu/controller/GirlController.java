package com.shaoyuanhu.controller;

import com.shaoyuanhu.domain.Girl;
import com.shaoyuanhu.dao.GirlRepository;
import com.shaoyuanhu.domain.Result;
import com.shaoyuanhu.service.GirlService;
import com.shaoyuanhu.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: ShaoYuanHu
 * @Description:
 * @Date: Create in 2018/1/21 11:55
 */
@RestController
public class GirlController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GirlController.class);

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
        LOGGER.info("this is getGirls method");
//        System.out.println("this is getGirls method");
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生信息
     * @Valid 制定校验的对象参数
     * BindingResult：校验的结果
     * @param girl
     * @return
     */
    @RequestMapping(value = "/addGirl")
    public Result<Girl> addGirl(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            //获取错误提示信息
            String message = bindingResult.getFieldError().getDefaultMessage();
//            System.out.println(message);
            return ResultUtil.error(1,message);
        }
        Girl save = girlRepository.save(girl);
        return ResultUtil.success(save);
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

    @GetMapping("/getAge/{id}")
    public void getAge(@PathVariable("id") Long id) throws Exception {
        girlService.getAge(id);
    }

}
