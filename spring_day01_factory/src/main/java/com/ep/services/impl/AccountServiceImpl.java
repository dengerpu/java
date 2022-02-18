package com.ep.services.impl;

import com.ep.dao.AccountDao;
import com.ep.dao.impl.AccountDaoImpl;
import com.ep.factory.BeanFactory;
import com.ep.services.AccountService;

/*
* 账户业务层实现类
* */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");

    //private int i=1;

    public void saveAccount() {
        int i =1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
