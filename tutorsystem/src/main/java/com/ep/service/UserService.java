package com.ep.service;

import com.ep.domain.User;
import org.springframework.stereotype.Service;

/**
 * 用户业务层接口
 * */
@Service
public interface UserService {

    /*
    * 用户登录
    * */
    public User Login(String username,String password,String type);

    /*
    * 用户注册
    * */
    public void saveLoginUser(User user);

    /*
    * 根据用户名查找用户
    * */
    public User findUserByUsername(String username);
}
