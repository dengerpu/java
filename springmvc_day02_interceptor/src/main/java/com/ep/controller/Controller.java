package com.ep.controller;

import com.ep.exception.SysException;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/user")
public class Controller {

    @RequestMapping("/testException")
    public String testException() throws SysException {
        System.out.println("testException方法执行了....");
        try {
            //模拟异常
            int i =10/0;
        } catch (Exception e) {
            //打印异常信息
            e.printStackTrace();
            //抛出自定义异常
            throw new SysException("查询用户出现了问题....");

        }
        return "success";
    }
}
