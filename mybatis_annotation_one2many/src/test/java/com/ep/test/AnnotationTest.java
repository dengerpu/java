package com.ep.test;

import com.ep.dao.UserDao;
import com.ep.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AnnotationTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private UserDao userDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(UserDao.class);
    }
    @After
    public void destory() throws Exception{
        session.commit();
        session.close();
        in.close();
    }


    /*
     * 测试删除
     * */
    @Test
    public void testDelte() throws Exception{
       userDao.DeleteUser(52);
    }

    /*
     * 测试根据id查询
     * */
    @Test  //mybatis默认开启了一级缓存
    public void testFindById() throws Exception{
        User user = userDao.FindUserById(49);
        System.out.println(user);

        User user1 = userDao.FindUserById(49);
        System.out.println(user1);

        System.out.println(user1 == user);
    }

    /*
     * 测试根据姓名模糊查询
     * */
    @Test
    public void testFindByName() throws Exception{
       // List<User> users = userDao.FindUserByName("%update%");
        List<User> users = userDao.FindUserByName("update");
        for (User user : users){
            System.out.println(user);
        }
    }

    /*
     * 测试查询总条数
     * */
    @Test
    public void testFindCount() throws Exception{
        Integer count = userDao.FindCountUser();
        System.out.println(count);
    }




}
