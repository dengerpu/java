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

import java.io.InputStream;
import java.util.List;

public class UserTest {
    private InputStream in;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession session;
    private UserDao userDao;

    @Before
    public void init() throws Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory的构建者对象
        builder = new SqlSessionFactoryBuilder();
        //3.使用构建者创建工厂对象SqlSessionFactory
        factory = builder.build(in);
        //4.使用SqlSessionFactory生产SqlSession对象
        session = factory.openSession();
        //5.使用SqlSession创建dao接口的代理对象
        userDao = session.getMapper(UserDao.class);

    }
    @After
    public void destory() throws Exception{
        //提交事务
        session.commit();
        //7.释放资源
        session.close();
        in.close();

    }

    /*
     * 测试查询所有用户以及所属的账号
     * */
    @Test
    public void testFindAll() throws Exception {
        List<User> users = userDao.findAll();
        for (User u : users){
            System.out.println(u);
            System.out.println(u.getRoles());
        }

    }




}
