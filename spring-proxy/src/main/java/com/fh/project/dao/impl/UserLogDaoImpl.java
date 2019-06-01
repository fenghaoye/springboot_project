package com.fh.project.dao.impl;

import com.fh.project.dao.UserDao;

public class UserLogDaoImpl implements UserDao {

    public UserLogDaoImpl(UserDao userDao) {
        userDao.query();
    }

    @Override
    public void query() {
        System.out.println("日志类");
    }
}
