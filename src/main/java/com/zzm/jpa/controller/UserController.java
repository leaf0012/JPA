package com.zzm.jpa.controller;

import com.zzm.jpa.bean.UserEntity;
import com.zzm.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author: 邹智敏
 * @Date: 2018/8/13   15:29
 * @Version: 1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list")
    public List<UserEntity> list()
    {
        return userService.list();
    }

    @RequestMapping(value = "/add")
    public String add(@RequestBody UserEntity userEntity)
    {
        userService.add(userEntity);
        return "用户信息添加成功";
    }

    @RequestMapping(value = "/delete")
    public int delete(String userId)
    {
        return userService.delete(userId);
    }

    @RequestMapping(value = "/age")
    public List<UserEntity> age(int age){
        return userService.age(age);
    }

    /**
     * 根据条件自定义编写删除SQL
     * @return
     */
    @RequestMapping(value = "/deleteWhere")
    public int deleteWhere(String userName, String userId)
    {
        return userService.deleteWhere(userName,userId);
    }

    /**
     * 分页查询测试
     * @param page 传入页码，从1开始
     * @return
     */
    @RequestMapping(value = "/cutpage")
    public List<UserEntity> cutPage(int page,String pageSort)
    {
        return userService.cutPage(page,pageSort);
    }
}
