package com.ep.test;

/*
* 测试mybatis的CRUD操作
* */

import com.ep.dao.UserDao;
import com.ep.dao.impl.UserDaoImpl;
import com.ep.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class mybatisTest {
    private InputStream in;
    private UserDao userDao;

    @Before
    public void init() throws Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂对象。创建dao对象
         userDao = new UserDaoImpl(factory);


    }
    @After
    public void destory() throws Exception{
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
     * 测试保存用户
     * */
    @Test
    public void testSaveUser() throws Exception {
        User user = new User();
        user.setUsername("dao insert");
        user.setAddress("河南省济源市");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.saveUser(user);
    }

    /*
     * 测试更新用户
     * */
    @Test
    public void testUpdateUser() throws Exception {
        User user = new User();
        user.setUsername("dao update");
        user.setAddress("河南省济源市");
        user.setSex("女");
        user.setBirthday(new Date());
        user.setId(51);
        userDao.updateUser(user);
    }

    /*
     * 测试删除用户
     * */
    @Test
    public void testDeleteUser() throws Exception {

        userDao.deleteUser(53);
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



}
