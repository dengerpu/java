package com.ep.jdbctemplate;

import com.ep.dao.AccountDao;
import com.ep.dao.impl.AccountDaoImpl;
import com.ep.domain.Account;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class jdbctemplate {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountDao accountDao = ac.getBean("accountDao", AccountDaoImpl.class);

//        Account account = accountDao.findAccountById(1);
//        System.out.println(account);

        Account aaa = accountDao.findAccountByName("bbb");
        System.out.println(aaa);

//        Account account = new Account();
//        account.setId(1);
//        account.setName("jdbc update");
//        account.setMoney(10000f);
//        accountDao.updateAccount(account);

    }

}
