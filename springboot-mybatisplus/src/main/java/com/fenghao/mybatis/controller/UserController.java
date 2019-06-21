package com.fenghao.mybatis.controller;

import com.fenghao.mybatis.entity.User;
import com.fenghao.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser")
    public List<User> getUser(){
        List<User> users = userService.queryList();
        System.out.println(users);
        return users;
    }


}
