package com.ep.dao;

import com.ep.domain.Account;

import java.util.List;

public interface AccountDao {

    /*
    * 查询所有账户
    * */
    List<Account> findAll();

    /*
     * 根据id查询
     * */


    List<Account> findById(Integer uid);

}
