package com.ep.service.impl;

import com.ep.domain.User;
import com.ep.mapper.UserMapper;
import com.ep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    /*
    * 用户登录
    * */
    @Override
    public User Login(String username,String password,String type) {
        User user = userMapper.Login(username, password, type);
        return user;
    }

    /*
    *
    * 用户注册
    * */
    @Override
    public void saveLoginUser(User user) {
        userMapper.saveLoginUser(user);
    }

    /*
     * 根据用户名查找用户
     * */
    @Override
    public User findUserByUsername(String username) {
        User user = userMapper.findUserByUsername(username);
        return user;
    }
}
