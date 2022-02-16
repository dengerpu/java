package com.ep.dao;


import com.ep.domain.QueryVo;
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

    /*
    * 多个对象条件查询
    * */
    List<User> findByQueryVo(QueryVo vo);

    /*
    * 条件查询
    * 查询的条件可能有用户名，可能有性别，也可能有地址，还有可能都有
    * */

    List<User> findByCondition(User user);


    /*
    * 根据id集合查询内容
    * */
    List<User> findByids(QueryVo vo);

}
