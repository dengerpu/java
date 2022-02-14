package com.ep.dao;


import com.ep.domain.User;

import java.util.List;

/*
* 用户持久层操作
* */
public interface UserDao {

    /**
     * 查询所有用户，同时获取到用户下的账户信息
     * */
    List<User> findAll();


    /*
    * 根据Id查询用户
    * */
    User findById(Integer id);


}
