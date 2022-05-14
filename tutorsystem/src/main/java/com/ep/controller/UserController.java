package com.ep.controller;

import com.ep.domain.*;
import com.ep.mapper.UserMapper;
import com.ep.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    /*
    * 用户登录
    * */
    @PostMapping("/login")
    @ResponseBody
    public ResultInfo Login(@RequestBody User userbody){
        String username = userbody.getUsername();
        String password = userbody.getPassword();
        String type = userbody.getType();

        User user = userService.Login(username, password, type);

        ResultInfo info = new ResultInfo();
        if(user==null){
            info.setStatus(400);
            info.setMsg("不存在该用户或者用户类型不对或账号或密码错误");
        }
        if(user!=null&&user.getStatus()==1){
            info.setStatus(400);
            info.setMsg("该用户已被锁定");
        }
        if(user!=null&&user.getStatus()==0){
            info.setStatus(200);
            info.setMsg("请求成功");
            user.setPassword("******");
            info.setData(user);
        }
        return info;
    }

    /*
     * 用户注册
     * 1.只能从已有的老师学生信息中注册，如果数据库中没有这个老师或学生的信息，不允许注册
     * */
    @RequestMapping(value = "/register",method = {RequestMethod.POST})
    @ResponseBody
    public ResultInfo Register(@RequestBody User user){
        ResultInfo info = new ResultInfo();

        User u = userService.findUserByUsername(user.getUsername());
        if(u!=null){
            info.setStatus(400);
            info.setMsg("用户已存在");
        }else{

            if(user.getType().equals("student")){
                Student student = userService.findStudent(user.getUsername());
                if(student==null){
                    info.setStatus(401);
                    info.setMsg("请联系管理员，不存在用户信息");
                }else{
                    userService.saveLoginUser(user);
                    info.setStatus(200);
                    info.setMsg("注册成功");
                }
            }else if(user.getType().equals("teacher")){
                Teacher teacher = userService.findTeacher(user.getUsername());
                if(teacher==null){
                    info.setStatus(401);
                    info.setMsg("请联系管理员，不存在用户信息");
                }else{
                    userService.saveLoginUser(user);
                    info.setStatus(200);
                    info.setMsg("注册成功");
                }
            }else{
                userService.saveLoginUser(user);
                info.setStatus(200);
                info.setMsg("注册成功");
            }
        }

        return info;
    }
    /*
     * 查找所有用户
     * */
    @RequestMapping(value = "/users",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindAllUser(String query,int pagenum,int pagesize){

        List<User> allUser = userService.findAllUser(query, pagenum, pagesize);
        PageBean pageBean = new PageBean();
        pageBean.setList(allUser);   //用户表
        pageBean.setCurrentPage(pagenum);//当前页数
        int total = userService.findTotalUser(query);
        pageBean.setTotalCount(total);   //总数据数
        pageBean.setPageSize(pagesize);  //每页显示条数
        int totalPage;
        if(total%pagesize==0){
            totalPage = total / pagesize;
        }else{
            totalPage = total / pagesize+1;
        }
        pageBean.setTotalPage(totalPage);  //总页数

        ResultInfo info = new ResultInfo();
        if(allUser.size()==0){
            info.setStatus(400);
            info.setMsg("无用户");
        }else{
            info.setData(pageBean);
            info.setStatus(200);
            info.setMsg("请求成功");
        }
        return info;
    }
    /*
     * 用户注册
     * */
    @RequestMapping(value = "/users",method = {RequestMethod.POST})
    @ResponseBody
    public ResultInfo AddUser(@RequestBody User user){

        User u = userService.findUserByUsername(user.getUsername());

        ResultInfo info = new ResultInfo();
        if(u!=null){
            info.setStatus(400);
            info.setMsg("用户已存在");
        }else{
            userService.saveLoginUser(user);
            info.setStatus(200);
            info.setMsg("注册成功");
        }

        return info;
    }

    /*
     * 根据id查找用户
     * */
    @RequestMapping(value = "/edituser",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindOneUser(int id){

        User user = userService.findUserById(id);

        //System.out.println(user);
        ResultInfo info = new ResultInfo();
        if(user==null){
            info.setStatus(400);
            info.setMsg("用户不存在");
        }else{
            info.setData(user);
            info.setStatus(200);
            info.setMsg("查找成功");
        }

        return info;
    }

    /*
     * 根据id修改用户
     * */
    @RequestMapping(value = "/edituser",method = {RequestMethod.POST})
    @ResponseBody
    public ResultInfo  EditOneUser(@RequestBody User user){

        ResultInfo info = new ResultInfo();
        try{
            userService.updateUserById(user);
            info.setStatus(200);
            info.setMsg("修改成功");

        }catch (Exception e){
            info.setStatus(400);
            info.setMsg("修改失败");
        }
        return info;
    }

    /*
    * 根据id删除用户
    * */
    @RequestMapping(value = "/deleteuser",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo  DeleteOneUser(int id){

        ResultInfo info = new ResultInfo();
        try{
            userService.deleteUserById(id);
            info.setStatus(200);
            info.setMsg("删除成功");

        }catch (Exception e){
            info.setStatus(400);
            info.setMsg("删除失败");
        }
        return info;
    }

    /**
     * 通过旧密码或者验证码修改密码
     * @param user
     * @return
     */
    @PostMapping("/updatepassword")
    @ResponseBody
    public ResultInfo updatePassword(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String newPassword = user.getNewPassword();
        ResultInfo info = new ResultInfo();
        try{
            userService.updatePassword(username,password,newPassword);
            info.setStatus(200);
            info.setMsg("修改密码成功");

        }catch (Exception e){
            info.setStatus(400);
            info.setMsg("修改密码失败");
        }
        return info;
    }
    /*
     * 查找用户总数
     * */
    @RequestMapping(value = "/findtotaluser",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindTotalUser( ){



        ResultInfo info = new ResultInfo();
        try{
            int totalUser = userService.findTotalUser("");
            info.setMsg("查询成功");
            info.setStatus(200);
            info.setData(totalUser);

        }catch (Exception e){
            System.out.println(e);
            info.setMsg("查找失败");
            info.setStatus(400);
        }

        return info;
    }





}
