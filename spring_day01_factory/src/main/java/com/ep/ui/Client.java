package com.ep.ui;


import com.ep.factory.BeanFactory;
import com.ep.services.AccountService;
import com.ep.services.impl.AccountServiceImpl;

/*
* 模拟一个表现层，用于调用业务层
* */
public class Client {
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            AccountService as = (AccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }

    }
}
