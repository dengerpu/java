package com.ep.dao.impl;

import com.ep.dao.UserDao;
import com.ep.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private SqlSessionFactory factory;
    public  UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }


    public List<User> findAll() {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调节SqlSession中的方法，实现查询列表
        List<User> users = session.selectList("com.ep.dao.UserDao.findAll");//参数就是能获取配置信息的key
        //3.释放资源
        session.close();
        return users;
    }

    public void saveUser(User user) {

        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调节SqlSession中的方法，实现查询列表
        session.insert("com.ep.dao.UserDao.saveUser", user);
        //3.提交事务
        session.commit();
        //4.释放资源
        session.close();

    }

    public void updateUser(User user) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调节SqlSession中的方法，实现查询列表
        session.update("com.ep.dao.UserDao.updateUser", user);
        //3.提交事务
        session.commit();
        //4.释放资源
        session.close();
    }

    public void deleteUser(Integer userid) {
//1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调节SqlSession中的方法，实现查询列表
        session.delete("com.ep.dao.UserDao.deleteUser", userid);
        session.commit();
        //3.释放资源
        session.close();
    }

    public User findById(Integer id) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调节SqlSession中的方法，实现查询列表
        User user = session.selectOne("com.ep.dao.UserDao.findById", id);
        //3.释放资源
        session.close();

        return user;
    }

    public List<User> findByName(String name) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调节SqlSession中的方法，实现查询列表
        List<User> users = session.selectList("com.ep.dao.UserDao.findByName", name);
        //3.释放资源
        session.close();

        return users;
    }

    public Integer findTotal() {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调节SqlSession中的方法，实现查询列表
        int total = session.selectOne("com.ep.dao.UserDao.findTotal");
        //3.释放资源
        session.close();
        return total;
    }
}
