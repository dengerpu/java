package com.ep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//视图控制器类
@Controller
@RequestMapping(path = "/user")
public class HelloController {

    //RequestMapping的属性
    //1. path 指定请求路径的url
    //2. value value属性和path属性是一样的
    //3. mthod 指定该方法的请求方式
    //4. params 指定限制请求参数的条件
    //5. headers 发送的请求中必须包含的请求头
    @RequestMapping(path = "/hello",method = {RequestMethod.POST,RequestMethod.GET},headers = "Accept",params = {"username"})
    public String sayHello(){
        System.out.println("Hello SpringMVC");
        return "success";
    }
}
