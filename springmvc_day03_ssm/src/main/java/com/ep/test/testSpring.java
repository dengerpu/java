package com.ep.test;


import com.ep.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSpring {

    @Test
    public void run1(){
        //1.读取配置文件
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //2.获取对象
        AccountServiceImpl accountService = ac.getBean("accountService", AccountServiceImpl.class);
        accountService.findAllAccount();

    }
}
