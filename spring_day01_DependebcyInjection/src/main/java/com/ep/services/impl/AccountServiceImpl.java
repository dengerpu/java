package com.ep.services.impl;


import com.ep.services.AccountService;

import java.util.Date;

/*
* 账户业务层实现类
* */
public class AccountServiceImpl implements AccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name,Integer age,Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("AccountService执行了saveAccount方法"+"name:"+name+"age:"+age+"birthday:"+birthday);
    }
}
