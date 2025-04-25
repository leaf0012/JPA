package com.zzm.jpa.service.Impl;

import com.zzm.jpa.bean.UserEntity;
import com.zzm.jpa.common.Result;
import com.zzm.jpa.jpa.UserJPA;
import com.zzm.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @Author: 邹智敏
 * @Date: 2018/8/13   15:14
 * @Version: 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJPA userJPA;

    @Transactional(rollbackForClassName={"RuntimeException","Exception"},readOnly=false)
    @Override
    public Integer add(UserEntity userEntity ) {
        userJPA.save(userEntity);
        return 1;
    }

    @Transactional(readOnly=true)
    @Override
    public List<UserEntity> list() {
        return userJPA.findAll();
    }

    @Transactional(rollbackForClassName={"RuntimeException","Exception"},readOnly=false)
    @Override
    public Integer delete(String userId) {
        userJPA.delete(userId);
        return 1;
    }

    @Transactional(readOnly=true)
    @Override
    public List<UserEntity> age(int age) {
        return userJPA.nativeQuery(age);
    }

    @Transactional(rollbackFor={RuntimeException.class, Exception.class},readOnly=false)
    @Override
    public Integer deleteWhere(String userName, String userId) {
        userJPA.deleteQuery(userName,userId);
        return 1;
    }

    @Transactional(readOnly=true)
    @Override
    public List<UserEntity> cutPage(int page,String pageSort) {
        UserEntity user = new UserEntity();
        user.setSord(pageSort);
        user.setPage(page);
        //获取排序对象
        Sort.Direction sort_direction = Sort.Direction.ASC.toString().equalsIgnoreCase(user.getSord()) ? Sort.Direction.ASC : Sort.Direction.DESC;
        //设置排序对象参数
        Sort sort = new Sort(sort_direction, user.getSidx());
        //创建分页对象
        PageRequest pageRequest = new PageRequest(user.getPage() - 1,user.getSize(),sort);
        //执行分页查询
        return userJPA.findAll(pageRequest).getContent();
    }
}
