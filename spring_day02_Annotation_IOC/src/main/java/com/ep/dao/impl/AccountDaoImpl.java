package com.ep.dao.impl;

import com.ep.dao.AccountDao;
import org.springframework.stereotype.Controller;

/**/
@Controller("accountDao1")
public class AccountDaoImpl implements AccountDao {

    public void saveAccount() {
        System.out.println("保存用户1111111111");
    }
}
