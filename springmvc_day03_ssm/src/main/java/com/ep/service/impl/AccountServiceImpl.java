package com.ep.service.impl;

import com.ep.dao.AccountDao;
import com.ep.domain.Account;
import com.ep.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAllAccount() {
        System.out.println("业务层:查询方法执行了...");

        return  accountDao.findAllAccount();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层:保存方法执行了...");
        accountDao.saveAccount(account);
    }
}
