package com.ep.ui;



import com.ep.dao.AccountDao;
import com.ep.dao.impl.AccountDaoImpl;
import com.ep.dao.impl.AccountDaoImpl2;
import com.ep.services.AccountService;
import com.ep.services.impl.AccountServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        //1.获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        AccountService accountService = (AccountServiceImpl)ac.getBean("accountService");
        AccountService accountService2 = (AccountServiceImpl)ac.getBean("accountService");

        System.out.println(accountService==accountService2);
     //   AccountDao accountDao = (AccountDaoImpl)ac.getBean("accountDao");



        System.out.println(accountService);
        //System.out.println(accountDao);

        accountService.saveAccount();

        ac.close();
    }
}
