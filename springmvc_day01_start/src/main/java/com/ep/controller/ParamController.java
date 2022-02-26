package com.ep.controller;

import com.ep.domain.Account;
import com.ep.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
* 请求参数绑定类
* */
@Controller
@RequestMapping("/param")
public class ParamController {

    /*
    * 请求参数绑定
    * */
    @RequestMapping(path="/login",params = {"username","password"},method = {RequestMethod.GET})
    public String test(String username,String password){
        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        return "success";
    }
    /*
     * 请求参数绑定，JavaBean类接收
     * */
    @RequestMapping(path="/login",method = {RequestMethod.POST})
    public String test(Account account){
        System.out.println(account);
        return "success";
    }
    /*
     * 请求参数绑定，自定义类型转换器，接收日期
     * */
    @RequestMapping(path="/register",method = {RequestMethod.POST})
    public String test(User user){
        System.out.println(user);
        return "success";
    }
    /*
     * 获取servelet原生API
     * */
    @RequestMapping(path="/servelet")
    public String testServelet(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request);
        System.out.println(request.getSession());
        System.out.println(request.getSession().getServletContext());
        return  "success";
    }
}
