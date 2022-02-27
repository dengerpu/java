package com.ep.controller;

import com.ep.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    //返回String类型
    @RequestMapping("/string")
    public String testString(Model model){
        System.out.println("testString方法执行了");
        User user = new User();
        user.setUsername("张三");
        user.setPassword("1234");
        user.setAge(18);
        model.addAttribute("user",user);
        return "success";
    }

    //返回void类型
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletResponse response, HttpServletRequest request) throws Exception {
        System.out.println("testVoid方法执行了");
        //请求转发
       // request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        //重定向
       // response.sendRedirect(request.getContextPath()+"/redirect.jsp");

        //设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //直接进行响应
        response.getWriter().print("你好");
        return ;
    }


    //返回ModelAndView类型
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView方法执行了");
        User user = new User();
        user.setUsername("李四");
        user.setPassword("4567");
        user.setAge(18);
        //把user对象存储到mv对象中，也把user对象存入request对象
        mv.addObject("user",user);
        //跳转到哪个页面
        mv.setViewName("success");
        return mv;
    }
    //关键字进行返回
    @RequestMapping("/testForwardorRedirect")
    public String testForwardorRedirect(){
        System.out.println("testForwardorRedirect方法执行了");

        //请求转发（不再使用视图解析器）
        //return "forward:/WEB-INF/pages/success.jsp";

        //重定向
        return "redirect:/redirect.jsp";

    }

    //异步请求返回
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax方法执行了");
        //客户端发送ajax请求，传送的是json字符串，后端把json字符串封装到user
        user.setUsername("json");
        return user;
    }
}
