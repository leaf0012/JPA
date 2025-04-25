package com.zzm.jpa.jpa;

import com.zzm.jpa.bean.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ClassName: UserJPA
 * @Description: TODO
 * @Author: 邹智敏
 * @Date: 2018/8/13   15:01
 * @Version: 1.0
 */
public interface  UserJPA extends JpaRepository<UserEntity,String> {
    /**
     * 查询大于20岁的用户
     * @param age
     * @return
     */
    @Query(value = "select * from user_info where UI_AGE > ?",nativeQuery = true)
    List<UserEntity> nativeQuery(int age);

    /**
     * 根据用户名、用户id删除一条数据
     * @param name
     * @param id
     */
    @Modifying
    @Query(value = "delete from user_info where UI_NAME = ? and UI_ID = ?",nativeQuery = true)
    void deleteQuery(String name,String id);
}
