package com.ep.service;

import com.ep.domain.Account;

import java.util.List;

/*
* 账户业务层实现类
* */
public interface  AccountService {
    //查询所有用户
    List<Account> findAllAccount();

    //保存用户
    void saveAccount(Account account);
}
