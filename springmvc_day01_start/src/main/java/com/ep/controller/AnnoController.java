package com.ep.controller;

import com.ep.domain.User;
import com.ep.utils.StringToDateConvertes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"})  //把msg=美美  存储到session域中去
public class AnnoController  {

    /*
    *
    * 1. RequestParam注解
        1. 作用：把请求中的指定名称的参数传递给控制器中的形参赋值
        2. 属性
        1. value：请求参数中的名称
        2. required：请求参数中是否必须提供此参数，默认值是true，必须提供
    * */
    @RequestMapping("/requestParam")
    public String testRequestParam(@RequestParam(name = "name") String username){
        System.out.println(username);
        return "success";
    }
    /*
  *
  *  RequestBody注解
        1. 作用：用于获取请求体的内容（注意：get方法不可以）
        2. 属性
        1. required：是否必须有请求体，默认值是true
  * */
    @RequestMapping("/requestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println(body );
        return "success";
    }

    /*
*
*  3. PathVariable注解
        1. 作用：拥有绑定url中的占位符的。例如：url中有/delete/{id}，{id}就是占位符
        2. 属性
        1. value：指定url中的占位符名称
        3. Restful风格的URL
        1. 请求路径一样，可以根据不同的请求方式去执行后台的不同方法
* */
    @RequestMapping("/pathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id){
        System.out.println(id );
        return "success";
    }

    /*
*
*  4. RequestHeader注解
        1. 作用：获取指定请求头的值
        2. 属性
        1. value：请求头的名称
* */
    @RequestMapping("/requestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String accept){
        System.out.println(accept );
        return "success";
    }

    /*
*
*  CookieValue注解
        1. 作用：用于获取指定cookie的名称的值
        2. 属性
        1. value：cookie的名称
* */
    @RequestMapping("/cookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookie){
        System.out.println(cookie );
        return "success";
    }

    /*
*
*  6. ModelAttribute注解
        1. 作用
        1. 出现在方法上：表示当前方法会在控制器方法执行前线执行。
        2. 出现在参数上：获取指定的数据给参数赋值。
        2. 应用场景
        1. 当提交表单数据不是完整的实体数据时，保证没有提交的字段使用数据库原来的数据。
* */
    @RequestMapping("/modelAttribute")
    public String testmodelAttribute(@ModelAttribute("abc") User user){
        System.out.println("请求执行了");
        System.out.println(user);
        return "success";
    }
    /*
     *
     * */
//    @ModelAttribute
//    public void showUser(String name, Map<String,User> map){
//        //模拟数据库操作
//        System.out.println("拿到用户名"+name);
//        User user = new User();
//        user.setName(name);
//        user.setAge(20);
//        user.setDate(new Date());
//        map.put("abc",user);
//    }

//    /*
//    *
//    * */
//    @ModelAttribute
//    public User showUser(String name){
//        //模拟数据库操作
//        System.out.println("拿到用户名"+name);
//        User user = new User();
//        user.setName(name);
//        user.setAge(20);
//        user.setDate(new Date());
//        return user;
//    }


    /*
*
*  SessionAttributes注解
        1. 作用：用于多次执行控制器方法间的参数共享
        2. 属性
        1. value：指定存入属性的名称
* */
    @RequestMapping("/sessionAttributes")
    public String testSessionAttributess(Model model){
        System.out.println("存取msg");
        //底层会存储到request域对象中
        model.addAttribute("msg","美美");
        return "success";
    }


    //得到session的值
    @RequestMapping("/getsessionAttributes")
    public String testgetsessionAttributes(ModelMap modelMap){
        System.out.println("取出msg");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }
    //删除session的值
    @RequestMapping("/deletesessionAttributes")
    public String testdeletesessionAttributes(SessionStatus status){
        System.out.println("msg被删除了");
        status.setComplete();
        return "success";
    }
}
