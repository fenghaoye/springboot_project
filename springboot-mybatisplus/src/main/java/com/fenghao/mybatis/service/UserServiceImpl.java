package com.fenghao.mybatis.service;

import com.fenghao.mybatis.entity.User;
import com.fenghao.mybatis.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> queryList(){
        //List<User> users = userDao.selectList(null);
        List<User> users = userDao.queryList();
        return users;
    }

}
