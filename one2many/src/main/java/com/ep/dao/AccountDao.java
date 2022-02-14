package com.ep.dao;

import com.ep.domain.Account;
import com.ep.domain.AccountUser;

import java.util.List;

public interface AccountDao {

    /*
    * 查询所有账户
    * */
    List<Account> findAll();

    /*
     * 查询所有账户以及对应的用户信息
     * */

    List<AccountUser> findAllAccountUser();



}
