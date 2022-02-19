package com.ep.factory;

import com.ep.services.AccountService;
import com.ep.services.impl.AccountServiceImpl;

public class InstanceFactory {
    public AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
