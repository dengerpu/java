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

public class SecondLevelCacheTest {
    private InputStream in;
    private SqlSessionFactory factory;


    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);

    }
    @After
    public void destory() throws Exception{
        in.close();
    }

    @Test
    public void testSecondCache(){
        SqlSession session = factory.openSession();
        UserDao userDao =session.getMapper(UserDao.class);
        User user = userDao.FindUserById(49);
        System.out.println(user);
        session.close();//释放一级缓存


        SqlSession session1 = factory.openSession();
        UserDao userDao1 =session1.getMapper(UserDao.class);
        User user1 = userDao1.FindUserById(49);
        System.out.println(user1);
        session1.close();




    }

}
