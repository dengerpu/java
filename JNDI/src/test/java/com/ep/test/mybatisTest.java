package com.ep.test;

/*
* 测试mybatis的CRUD操作
* */

import com.ep.dao.UserDao;
import com.ep.domain.QueryVo;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class mybatisTest {
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
    * 测试查询所有用户
    * */
    @Test
    public void testFindAll() throws Exception {
        //6.使用代理对象执行查询所有方法
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
        }
    }


    /*
     * 根据Id查找用户
     * */
    @Test
    public void testFindByID() throws Exception {
       User user = userDao.findById(49);
        System.out.println(user);
    }

    /*
     * 根据姓名模糊查询
     * */
    @Test
    public void testFindByName() throws Exception {
       List<User> users = userDao.findByName("%王%");
       // List<User> users = userDao.findByName("王");
        for(User user:users){
            System.out.println(user);
        }
    }

    /*
     * 查询总条数
     * */
    @Test
    public void testFindTota() throws Exception {
        Integer all = userDao.findTotal();
        System.out.println(all);
    }

    /*
     * 多个条件查询
     * */
    @Test
    public void testFindQueryVo() throws Exception {
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        queryVo.setUser(user);
        List<User> users = userDao.findByQueryVo(queryVo);
        // List<User> users = userDao.findByName("王");
        for(User u:users){
            System.out.println(u);
        }
    }

    /*
     * 条件查询
     * */
    @Test
    public void testfindByCondition() throws Exception {
        User user = new User();
        user.setUsername("%王%");
        user.setSex("");

        List<User> users = userDao.findByCondition(user);
        // List<User> users = userDao.findByName("王");
        for(User u:users){
            System.out.println(u);
        }
    }


    /*
     * id集合查询
     * */
    @Test
    public void testfindByids() throws Exception {
        QueryVo queryVo = new QueryVo();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(51);
        list.add(52);
        list.add(54);
        queryVo.setIds(list);
        List<User> users = userDao.findByids(queryVo);

        // List<User> users = userDao.findByName("王");
        for(User u:users){
            System.out.println(u);
        }
    }


}
