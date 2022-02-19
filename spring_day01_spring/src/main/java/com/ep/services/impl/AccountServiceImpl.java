package com.ep.services.impl;

import com.ep.dao.AccountDao;
import com.ep.dao.impl.AccountDaoImpl;
import com.ep.services.AccountService;

/*
* 账户业务层实现类
* */
public class AccountServiceImpl implements AccountService {

    public  AccountServiceImpl(){
        System.out.println("对象创建了\n");
    }
    public void saveAccount() {
       // accountDao.saveAccount();
    }
}
