package com.ep.test;

import com.ep.dao.AccountDao;
import com.ep.dao.UserDao;
import com.ep.domain.Account;
import com.ep.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private AccountDao accountDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        accountDao = session.getMapper(AccountDao.class);
    }
    @After
    public void destory() throws Exception{
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testFindAllAccount(){
        List<Account> accounts = accountDao.FindAll();
        for(Account account:accounts){
            System.out.println(account);
            System.out.println(account.getUser());
        }

    }

    @Test
    public void testFindAccountById(){
        List<Account> accounts = accountDao.FindAccountByUID("46");
        for(Account account:accounts){
            System.out.println(account);
        }


    }


}
