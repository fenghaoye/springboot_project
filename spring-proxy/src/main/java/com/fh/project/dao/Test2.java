package com.fh.project.dao;



import com.fh.project.dao.impl.UserDaoImpl;
import com.fh.project.dao.util.ProxyUtil;

import java.lang.reflect.Proxy;


public class Test2 {
    public static void main(String[] args) {

        UserDao proxy = (UserDao) ProxyUtil.newInstance(new UserDaoImpl());
        proxy.query();

    }
}
