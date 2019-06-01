package com.fh.project.dao.impl;

import com.fh.project.dao.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public void query() {
        System.out.println("查询数据库");
    }
}
