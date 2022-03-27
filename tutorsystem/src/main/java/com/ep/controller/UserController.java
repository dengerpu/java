package com.ep.controller;

import com.ep.domain.ResultInfo;
import com.ep.domain.User;
import com.ep.mapper.UserMapper;
import com.ep.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    /*
    * 用户登录
    * */
    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    @ResponseBody
    public ResultInfo Login(String username,String password,String type){
        User user = userService.Login(username, password, type);

        ResultInfo info = new ResultInfo();
        if(user==null){
            info.setStatus(400);
            info.setMsg("不存在该用户");

        }
        if(user!=null&&user.getStatus()==0){
            info.setStatus(400);
            info.setMsg("该用户已被锁定");
        }
        if(user!=null&&user.getStatus()==1){
            info.setStatus(200);
            info.setMsg("请求成功");
            info.setData(user);
        }
        return info;
    }

    /*
     * 用户注册
     * */
    @RequestMapping(value = "/register",method = {RequestMethod.POST})
    @ResponseBody
    public ResultInfo Register(User user){

        User u = userService.findUserByUsername(user.getUsername());

        ResultInfo info = new ResultInfo();
        if(u!=null){
            info.setStatus(400);
            info.setMsg("用户已存在");
        }else{
            userService.saveLoginUser(user);
            info.setStatus(201);
            info.setMsg("注册成功");
        }

        return info;
    }


}
