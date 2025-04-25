package com.zzm.jpa.service;

import com.zzm.jpa.bean.UserEntity;

import java.util.List;

public interface UserService{
    /**
     * 新增
     * @return
     */
    Integer add(UserEntity userEntity );

    /**
     * 查询
     * @return
     */
    List<UserEntity> list();

    /**
     * 删除
     */
    Integer delete(String userId);

    /**
     * 按年龄查询
     */
    List<UserEntity> age(int age);

    /**
     * 根据条件自定义编写删除SQL
     */
    Integer deleteWhere(String userName, String userId);

    /**
     * 分页查询测试
     * @param page
     */
    List<UserEntity> cutPage(int page,String pageSort);
}
