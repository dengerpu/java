package com.ep.factory;

import com.ep.services.AccountService;
import com.ep.services.impl.AccountServiceImpl;

public class StaticFactory {
    public static AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
