package com.ep.service.impl;

import com.ep.domain.Student;
import com.ep.domain.Teacher;
import com.ep.domain.User;
import com.ep.mapper.UserMapper;
import com.ep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /*
    * 查找学生用户
    * */
    @Override
    public Student findStudent(String username) {
        Student student = userMapper.findUserNameByUsernameStudent(username);
        return student;
    }

    /*
    * 查找老师用户
    * */
    @Override
    public Teacher findTeacher(String username) {
        Teacher teacher = userMapper.findUserNameByUsernameTeacher(username);
        return teacher;
    }

    /*
    * 查询所用用户
    * */
    @Override
    public List<User> findAllUser(String query,int pagenum,int pagesize) {
        int start = (pagenum-1)*pagesize;  //pagenum，第几页，pagesize每页的大小
        List<User> allUser = userMapper.findAllUser(query,start,pagesize);
        return allUser;
    }
    /*
     * 查询用户总数
     * */
    @Override
    public int findTotalUser(String query){
        int totalUser = userMapper.findTotalUser(query);
        return totalUser;
    }
    /*
    *
    * 根据id查询用户
    * */
    @Override
    public User findUserById(int id) {
        User user = userMapper.findUserById(id);
        return user;
    }


    /*
    * 根据id删除用户
    * */
    @Override
    public void deleteUserById(int id) {
        userMapper.deleteUserById(id);
    }

    /*
    * 根据id修改用户
    * */
    @Override
    public void updateUserById(User user) {
        userMapper.updateUserById(user);
    }

    /*
    * 找回密码，根据用户名和邮箱核实用户信息
    * */
    @Override
    public User findUserByUsernameAndEmail(String username, String email, String type) {
        User user = userMapper.findUserByusernameAndEmail(username, email, type);
        return user;
    }

    /*
    * 修改密码，根据邮箱
    * */
    @Override
    public void updatePasswordByEmail(String username, String email, String type, String password) {
        userMapper.updateUserPasswordByEmail(username, email, type, password);
    }

    /*
    * 查找所有用户邮箱
    * */
    @Override
    public List<String> findAllUserEmail() {
        List<String> allUserEmail = userMapper.findAllUserEmail();
        return allUserEmail;
    }

    /*
    * 查找导师负责学生的邮箱
    * */
    @Override
    public List<String> findMyStudentmail(int tid) {
        List<String> myStudentEmail = userMapper.findMyStudentEmail(tid);
        return myStudentEmail;
    }

    /*
    * 更改邮箱
    * */
    @Override
    public void updateEmail(String username, String newEmail) {
        userMapper.updateEmail(username, newEmail);
    }

    /*
    * 更改密码
    * */
    @Override
    public void updatePassword(String username, String password, String newPassword) {
        userMapper.updatePassword(username, password, newPassword);
    }
}
