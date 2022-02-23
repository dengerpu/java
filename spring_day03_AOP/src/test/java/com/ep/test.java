package com.ep;

import com.ep.service.AccountService;
import com.ep.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    @Test
    public void testaop(){
       ClassPathXmlApplicationContext ac = new  ClassPathXmlApplicationContext("bean.xml");

        AccountService as = (AccountService) ac.getBean("accountService");
        as.saveAccount();
        as.deleteAccount();
        as.uodateAccount(1);

    }
}
