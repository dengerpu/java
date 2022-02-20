package com.ep.dao.impl;

import com.ep.dao.AccountDao;
import org.springframework.stereotype.Controller;

@Controller(value = "accountDao2")
public class AccountDaoImpl2 implements AccountDao {
    public void saveAccount() {
        System.out.println("保存用户2222222222");
    }
}
