package com.ep.dao;


import com.ep.domain.User;

import java.util.List;

/*
* 用户持久层操作
* */
public interface UserDao {

    /**
     * 查询所有用户
     * */
    List<User> findAll();

    /*
    * 保存用户操作
    * */
    void saveUser(User user);

    /*
    * 更新用户操作
    * */
    void updateUser(User user);

    /*
    * 根据Id删除用户
    * */
    void deleteUser( Integer userid);

    /*
    * 根据Id查询用户
    * */
    User findById(Integer id);

    /*
    * 模糊查找
    * */
    List<User> findByName(String name);

    /*
    * 查询总条数
    * */
    Integer findTotal();


}
