package com.fenghao.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fenghao.mybatis.entity.User;

import java.util.List;

public interface UserDao extends BaseMapper<User> {

     List<User> queryList();
}
